package com.baidu.searchbox.ugc.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.searchbox.ugc.R;
import com.baidu.searchbox.ugc.utils.ResourceUtils;
import com.baidu.searchbox.ugc.utils.UiBaseUtils;
/* loaded from: classes11.dex */
public class VoteOptionsItemView extends LinearLayout {
    private Context mContext;
    private TextView mVoteOptionsText;

    public VoteOptionsItemView(Context context) {
        super(context);
        init(context);
    }

    public VoteOptionsItemView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public VoteOptionsItemView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.ugc_vote_item_view, this);
        this.mContext = context;
        this.mVoteOptionsText = (TextView) findViewById(ResourceUtils.getResIdByName("ugc_vote_option_text"));
    }

    private void setVoteRedItemChecked(String str) {
        setVoteItemCheckedStyle(str, ContextCompat.getDrawable(this.mContext, R.drawable.ugc_vote_red_selector_bg), ContextCompat.getColor(this.mContext, R.color.ugc_vote_red_isChecked), ContextCompat.getDrawable(this.mContext, R.drawable.ugc_vote_red_is_checked));
    }

    private void setVoteYellowItemChecked(String str) {
        setVoteItemCheckedStyle(str, ContextCompat.getDrawable(this.mContext, R.drawable.ugc_vote_yellow_selector_bg), ContextCompat.getColor(this.mContext, R.color.ugc_vote_yellow_isChecked), ContextCompat.getDrawable(this.mContext, R.drawable.ugc_vote_yellow_is_checked));
    }

    private void setVoteBlueItemChecked(String str) {
        setVoteItemCheckedStyle(str, ContextCompat.getDrawable(this.mContext, R.drawable.ugc_vote_blue_selector_bg), ContextCompat.getColor(this.mContext, R.color.ugc_vote_blue_isChecked), ContextCompat.getDrawable(this.mContext, R.drawable.ugc_vote_blue_is_checked));
    }

    private void setVoteItemCheckedStyle(String str, Drawable drawable, int i, Drawable drawable2) {
        UiBaseUtils.setTextString(this.mVoteOptionsText, str);
        UiBaseUtils.setViewBackgroundDrawable(this.mVoteOptionsText, drawable);
        UiBaseUtils.setTextColor(this.mVoteOptionsText, i);
        UiBaseUtils.setCompoundDrawablesWithIntrinsicBounds(this.mVoteOptionsText, drawable2, null, null, null);
        UiBaseUtils.setCompoundDrawablePadding(this.mVoteOptionsText, getResources().getDimensionPixelSize(R.dimen.ugc_vote_item_img_padding));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x004e, code lost:
        if (r5.equals("红方") != false) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setVoteItemForIsChecked(String str, String str2) {
        char c = 0;
        if (str2.length() > 8) {
            str2 = str2.substring(0, 7) + StringHelper.STRING_MORE;
        }
        String str3 = str + ": " + str2;
        switch (str.hashCode()) {
            case 1030999:
                break;
            case 1080444:
                if (str.equals("蓝方")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 1286005:
                if (str.equals("黄方")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                setVoteRedItemChecked(str3);
                return;
            case 1:
                setVoteYellowItemChecked(str3);
                return;
            case 2:
                setVoteBlueItemChecked(str3);
                return;
            default:
                return;
        }
    }

    public void setVoteItemDefault(String str) {
        if (this.mVoteOptionsText != null) {
            UiBaseUtils.setTextString(this.mVoteOptionsText, str);
            UiBaseUtils.setTextColorResource(this.mVoteOptionsText, R.color.ugc_vote_item_text_selctor);
            UiBaseUtils.setViewDrawableResource(this.mVoteOptionsText, R.drawable.ugc_vote_item_bg_selctor);
            UiBaseUtils.setCompoundDrawablesWithIntrinsicBounds(this.mVoteOptionsText, null, null, null, null);
        }
    }
}
