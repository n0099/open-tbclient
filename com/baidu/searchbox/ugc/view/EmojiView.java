package com.baidu.searchbox.ugc.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.searchbox.ugc.R;
import com.baidu.searchbox.ugc.emoji.EmojiAdapter;
import com.baidu.searchbox.ugc.emoji.EmojiPagerAdapter;
import com.baidu.searchbox.ugc.emoji.Emojicon;
import com.baidu.searchbox.ugc.emoji.PageFive;
import com.baidu.searchbox.ugc.emoji.PageFour;
import com.baidu.searchbox.ugc.emoji.PageOne;
import com.baidu.searchbox.ugc.emoji.PageSix;
import com.baidu.searchbox.ugc.emoji.PageThree;
import com.baidu.searchbox.ugc.emoji.PageTwo;
import com.baidu.searchbox.ugc.utils.ResourceUtils;
import com.baidu.searchbox.ugc.utils.UiBaseUtils;
import java.util.ArrayList;
/* loaded from: classes13.dex */
public class EmojiView extends LinearLayout {
    private ViewPager mEmojisPager;
    private ImageView[] mImageViews;
    private LinearLayout mViewsDot;

    public EmojiView(Context context) {
        super(context);
    }

    public EmojiView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public EmojiView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void initEmojiView(final EditText editText) {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.ugc_emoji_layout, (ViewGroup) null);
        UiBaseUtils.setViewColorResource(inflate, R.color.ugc_publish_progressbar_color);
        this.mViewsDot = (LinearLayout) inflate.findViewById(ResourceUtils.getResIdByName("ugc_emojis_viewgroup"));
        this.mEmojisPager = (ViewPager) inflate.findViewById(ResourceUtils.getResIdByName("ugc_emojis_pager"));
        ArrayList arrayList = new ArrayList();
        arrayList.add(PageOne.DATA);
        arrayList.add(PageTwo.DATA);
        arrayList.add(PageThree.DATA);
        arrayList.add(PageFour.DATA);
        arrayList.add(PageFive.DATA);
        arrayList.add(PageSix.DATA);
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < arrayList.size(); i++) {
            GridView gridView = new GridView(getContext());
            gridView.setNumColumns(7);
            gridView.setPadding(0, DeviceUtil.ScreenInfo.dp2px(getContext(), 15.0f), 0, DeviceUtil.ScreenInfo.dp2px(getContext(), 15.0f));
            gridView.setVerticalScrollBarEnabled(true);
            gridView.setVerticalSpacing((int) getResources().getDimension(R.dimen.bd_im_emoji_row_space));
            gridView.setHorizontalSpacing((int) getResources().getDimension(R.dimen.bd_im_emoji_column_space));
            gridView.setSelector(R.drawable.ugc_bd_im_button_emoji);
            UiBaseUtils.setViewDrawableResource(gridView, R.drawable.ugc_bd_im_button_emoji);
            UiBaseUtils.setViewColorResource(gridView, R.color.ugc_publish_progressbar_color);
            final Emojicon[] emojisData = getEmojisData((Emojicon[]) arrayList.get(i));
            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.searchbox.ugc.view.EmojiView.1
                @Override // android.widget.AdapterView.OnItemClickListener
                public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                    if (i2 != emojisData.length - 1) {
                        EmojiView.this.emojiInput(editText, (Emojicon) adapterView.getItemAtPosition(i2));
                    } else {
                        EmojiView.this.emojiBackspace(editText);
                    }
                }
            });
            gridView.setAdapter((ListAdapter) new EmojiAdapter(getContext(), emojisData));
            arrayList2.add(gridView);
        }
        this.mImageViews = new ImageView[arrayList.size()];
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            ImageView imageView = new ImageView(getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(DeviceUtil.ScreenInfo.dp2px(getContext(), 6.0f), 0, DeviceUtil.ScreenInfo.dp2px(getContext(), 6.0f), 0);
            imageView.setLayoutParams(layoutParams);
            this.mImageViews[i2] = imageView;
            if (this.mViewsDot != null) {
                this.mViewsDot.addView(this.mImageViews[i2]);
            }
        }
        if (this.mEmojisPager != null) {
            this.mEmojisPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.searchbox.ugc.view.EmojiView.2
                @Override // android.support.v4.view.ViewPager.OnPageChangeListener
                public void onPageScrolled(int i3, float f, int i4) {
                }

                @Override // android.support.v4.view.ViewPager.OnPageChangeListener
                public void onPageSelected(int i3) {
                    EmojiView.this.emojiPageSelect(i3);
                }

                @Override // android.support.v4.view.ViewPager.OnPageChangeListener
                public void onPageScrollStateChanged(int i3) {
                }
            });
        }
        emojiPageSelect(0);
        EmojiPagerAdapter emojiPagerAdapter = new EmojiPagerAdapter(arrayList2);
        if (this.mEmojisPager != null) {
            this.mEmojisPager.setAdapter(emojiPagerAdapter);
        }
        addView(inflate);
    }

    private Emojicon[] getEmojisData(Emojicon[] emojiconArr) {
        Emojicon[] emojiconArr2 = new Emojicon[emojiconArr.length + 1];
        for (int i = 0; i < emojiconArr.length; i++) {
            emojiconArr2[i] = emojiconArr[i];
        }
        return emojiconArr2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void emojiPageSelect(int i) {
        for (int i2 = 0; i2 < this.mImageViews.length; i2++) {
            if (i == i2) {
                UiBaseUtils.setImageResource(this.mImageViews[i2], R.drawable.ugc_bd_im_round_dot_select);
            } else {
                UiBaseUtils.setImageResource(this.mImageViews[i2], R.drawable.ugc_bd_im_round_dot_normal);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void emojiInput(EditText editText, Emojicon emojicon) {
        if (editText != null && emojicon != null) {
            int selectionStart = editText.getSelectionStart();
            int selectionEnd = editText.getSelectionEnd();
            if (selectionStart < 0) {
                editText.append(emojicon.getEmoji());
            } else {
                editText.getText().replace(Math.min(selectionStart, selectionEnd), Math.max(selectionStart, selectionEnd), emojicon.getEmoji(), 0, emojicon.getEmoji().length());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void emojiBackspace(EditText editText) {
        editText.dispatchKeyEvent(new KeyEvent(0L, 0L, 0, 67, 0, 0, 0, 0, 6));
    }
}
