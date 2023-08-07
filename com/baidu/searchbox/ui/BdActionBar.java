package com.baidu.searchbox.ui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.DimenRes;
import androidx.core.content.res.ResourcesCompat;
import com.baidu.android.ext.widget.menu.BdMenu;
import com.baidu.android.ext.widget.menu.BdMenuItem;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.searchbox.bdeventbus.Action;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.config.FontSizeHelper;
import com.baidu.searchbox.config.eventmessage.FontSizeChangeMessage;
import com.baidu.searchbox.config.ext.FontSizeImageViewExtKt;
import com.baidu.searchbox.config.ext.FontSizeTextViewExtKt;
import com.baidu.searchbox.config.ext.FontSizeViewExtKt;
import java.util.List;
import kotlin.Deprecated;
/* loaded from: classes4.dex */
public class BdActionBar extends RelativeLayout {
    public static final int TEXT_ALIGN_CENTER = 1;
    public static final int TEXT_ALIGN_LEFT = 0;
    public static final int TEXT_ALIGN_RIGHT = 2;
    public static final int[] VISIBILITY_FLAGS = {8, 0, 4};
    public boolean isLeftBack;
    public OnDoubleClickListener mDoubleClickListener;
    public boolean mIsLeftTitleInvalidate;
    public boolean mIsResponseFontSizeScale;
    public FrameLayout mLeftCustomLayout;
    public TextView mLeftFirstView;
    public int mLeftFirstViewImageSrcId;
    public TextView mLeftSecondView;
    public View mLeftZones;
    public CommonOverflowMenu mMenu;
    public BdMenu.OnMenuItemsUpdateListener mMenuItemsUpdateListener;
    public View.OnClickListener mOnClickListener;
    public BdMenuItem.OnItemClickListener mOnItemClickListener;
    public View mRightImgZone1;
    public BdBaseImageView mRightImgZone1Image;
    public Drawable mRightImgZone1ImageSrc;
    public int mRightImgZone1ImageSrcId;
    public int mRightImgZone1Visibility;
    public View mRightImgZone2;
    public BdBaseImageView mRightImgZone2Image;
    public Drawable mRightImgZone2ImageSrc;
    public int mRightImgZone2ImageSrcId;
    public View mRightImgZone2Notify;
    public BdBaseImageView mRightImgZone2Tips;
    public int mRightImgZone2Visibility;
    public View mRightMenu;
    public ImageView mRightMenuImageView;
    public int mRightMenuImageViewSrcId;
    public View mRightTxtZone1;
    public ProgressBar mRightTxtZone1Progress;
    public TextView mRightTxtZone1Text;
    public String mRightTxtZone1TextString;
    public int mRightTxtZone1TxtColor;
    public int mRightTxtZone1Visibility;
    public View mRightTxtZone2;
    public TextView mRightTxtZone2Text;
    public String mRightTxtZone2TextString;
    public int mRightTxtZone2TxtColor;
    public int mRightTxtZone2Visibility;
    public View mRightZones;
    public int mRightZonesVisibility;
    public int mScaledType;
    public String mSubTitleText;
    public TextView mSubTitleViewCenter;
    public int mTitleAlignment;
    public int mTitleColorId;
    public String mTitleText;
    public int mTitleTxtShadowColor;
    public float mTitleTxtShadowDx;
    public float mTitleTxtShadowDy;
    public float mTitleTxtShadowRadius;
    public TextView mTitleViewCenter;

    /* loaded from: classes4.dex */
    public enum ActionbarTemplate {
        WHITE_TITLE_TEMPLATE,
        BALCK_TITLE_TEMPLATE
    }

    /* loaded from: classes4.dex */
    public interface OnDoubleClickListener {
        void onDoubleClick(View view2);
    }

    private void resetCenterTextViewPadding(String str) {
    }

    /* renamed from: com.baidu.searchbox.ui.BdActionBar$5  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass5 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$searchbox$ui$BdActionBar$ActionbarTemplate;

        static {
            int[] iArr = new int[ActionbarTemplate.values().length];
            $SwitchMap$com$baidu$searchbox$ui$BdActionBar$ActionbarTemplate = iArr;
            try {
                iArr[ActionbarTemplate.WHITE_TITLE_TEMPLATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$ui$BdActionBar$ActionbarTemplate[ActionbarTemplate.BALCK_TITLE_TEMPLATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class GestureListener extends GestureDetector.SimpleOnGestureListener {
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        public GestureListener() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (BdActionBar.this.mDoubleClickListener != null) {
                BdActionBar.this.mDoubleClickListener.onDoubleClick(BdActionBar.this);
            }
            return super.onDoubleTap(motionEvent);
        }
    }

    private void initMenu() {
        if (this.mMenu == null) {
            CommonOverflowMenu commonOverflowMenu = new CommonOverflowMenu(this);
            this.mMenu = commonOverflowMenu;
            commonOverflowMenu.setMenuItemClickListener(this.mOnItemClickListener);
            this.mMenu.setMenuItemsUpdateListener(new BdMenu.OnMenuItemsUpdateListener() { // from class: com.baidu.searchbox.ui.BdActionBar.2
                @Override // com.baidu.android.ext.widget.menu.BdMenu.OnMenuItemsUpdateListener
                public void onMenuItemUpdated(List<BdMenuItem> list) {
                    if (BdActionBar.this.mMenuItemsUpdateListener != null) {
                        BdActionBar.this.mMenuItemsUpdateListener.onMenuItemUpdated(list);
                    }
                }
            });
        }
        this.mRightZones.setVisibility(8);
        this.mRightMenu.setVisibility(0);
    }

    public void dismissMenu() {
        CommonOverflowMenu commonOverflowMenu = this.mMenu;
        if (commonOverflowMenu != null) {
            commonOverflowMenu.dismiss();
        }
    }

    public FrameLayout getLeftCustomLayout() {
        return this.mLeftCustomLayout;
    }

    public boolean getLeftFirstBack() {
        return this.isLeftBack;
    }

    public View getLeftFirstView() {
        return this.mLeftFirstView;
    }

    public View getRightImgZone1() {
        return this.mRightImgZone1;
    }

    public int getRightImgZone1ImageSrcId() {
        return this.mRightImgZone1ImageSrcId;
    }

    public View getRightImgZone2() {
        return this.mRightImgZone2;
    }

    public View getRightImgZone2Image() {
        return this.mRightImgZone2Image;
    }

    public int getRightImgZone2ImageSrcId() {
        return this.mRightImgZone2ImageSrcId;
    }

    public int getRightImgZone2NotifyVisibility() {
        return this.mRightImgZone2Notify.getVisibility();
    }

    public View getRightMenu() {
        return this.mRightMenu;
    }

    public int getRightMenuImageViewSrcId() {
        return this.mRightMenuImageViewSrcId;
    }

    public View getRightTxtView() {
        return this.mRightTxtZone1Text;
    }

    public int getRightTxtZone1ProgressVisibility() {
        return this.mRightTxtZone1Progress.getVisibility();
    }

    public int getRightTxtZone1Visibility() {
        return this.mRightTxtZone1.getVisibility();
    }

    public int getRightTxtZone2Visibility() {
        return this.mRightTxtZone2.getVisibility();
    }

    public String getSubTitle() {
        return this.mSubTitleText;
    }

    public String getTitle() {
        return this.mTitleText;
    }

    public int getTitleColorId() {
        return this.mTitleColorId;
    }

    public void hideRightTxtZone1Progress() {
        this.mRightTxtZone1Text.setVisibility(0);
        this.mRightTxtZone1Progress.setVisibility(4);
        this.mRightTxtZone1.setClickable(true);
        invalidate();
    }

    public boolean isLeftZoneImageSelected() {
        return this.mLeftFirstView.isSelected();
    }

    public boolean isRightImgZone1Visible() {
        if (this.mRightImgZone1.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    public boolean isRightMeuVisible() {
        if (this.mRightMenu.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    public boolean isRightZone2Visible() {
        if (this.mRightImgZone2.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    public void notifyMenuSetChanged() {
        CommonOverflowMenu commonOverflowMenu = this.mMenu;
        if (commonOverflowMenu != null) {
            commonOverflowMenu.notifyMenuSetChanged();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        BdEventBus.Companion.getDefault().register(this, FontSizeChangeMessage.class, 1, new Action<FontSizeChangeMessage>() { // from class: com.baidu.searchbox.ui.BdActionBar.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.bdeventbus.Action
            public void call(FontSizeChangeMessage fontSizeChangeMessage) {
                BdActionBar.this.onFontSizeChange();
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        BdEventBus.Companion.getDefault().unregister(this);
    }

    public void showRightTxtZone1Progress() {
        this.mRightTxtZone1Text.setVisibility(4);
        this.mRightTxtZone1Progress.setVisibility(0);
        this.mRightTxtZone1.setClickable(false);
        invalidate();
    }

    public BdActionBar(Context context) {
        super(context);
        this.isLeftBack = true;
        this.mRightTxtZone1TxtColor = -1;
        this.mScaledType = 0;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.searchbox.ui.BdActionBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                BdActionBar.this.toggleMenu();
            }
        };
        this.mRightTxtZone2TxtColor = -1;
        this.mIsResponseFontSizeScale = true;
        init();
    }

    private Drawable getDrawableFromId(int i) {
        Drawable drawable = getResources().getDrawable(i);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        return drawable;
    }

    private void setActionBarHeight(int i) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = i;
        setLayoutParams(layoutParams);
    }

    private void updateImageViewFontSize(ImageView imageView) {
        if (imageView == null) {
            return;
        }
        FontSizeImageViewExtKt.setScaledImageDrawable(imageView, this.mScaledType, imageView.getDrawable());
    }

    public BdActionBar addMenuItem(BdMenuItem bdMenuItem) {
        initMenu();
        this.mMenu.addMenuItem(bdMenuItem);
        return this;
    }

    public BdMenuItem findItem(int i) {
        CommonOverflowMenu commonOverflowMenu = this.mMenu;
        if (commonOverflowMenu == null) {
            return null;
        }
        return commonOverflowMenu.findItem(i);
    }

    public int findItemIndex(int i) {
        CommonOverflowMenu commonOverflowMenu = this.mMenu;
        if (commonOverflowMenu == null) {
            return -1;
        }
        return commonOverflowMenu.findItemIndex(i);
    }

    public void notifyMenuItemUpdated(BdMenuItem bdMenuItem) {
        this.mMenu.notifyMenuItemUpdated(bdMenuItem);
    }

    public BdActionBar removeItem(int i) {
        CommonOverflowMenu commonOverflowMenu = this.mMenu;
        if (commonOverflowMenu != null) {
            commonOverflowMenu.removeItem(i);
        }
        return this;
    }

    public void setIsResponseFontSizeScale(boolean z) {
        this.mIsResponseFontSizeScale = z;
        onFontSizeChange();
    }

    public void setLeftFirstBack(boolean z) {
        this.isLeftBack = z;
    }

    public void setLeftFirstViewSelector(ColorStateList colorStateList) {
        TextView textView = this.mLeftFirstView;
        if (textView == null) {
            return;
        }
        textView.setTextColor(colorStateList);
    }

    public void setLeftFirstViewVisibility(int i) {
        TextView textView = this.mLeftFirstView;
        if (textView != null) {
            textView.setVisibility(i);
        }
    }

    public void setLeftSecondViewClickListener(View.OnClickListener onClickListener) {
        this.mLeftSecondView.setOnClickListener(onClickListener);
    }

    public void setLeftSecondViewImageSrc(int i) {
        Drawable drawable;
        if (i != 0) {
            drawable = getResources().getDrawable(i);
        } else {
            drawable = null;
        }
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        this.mLeftSecondView.setCompoundDrawables(drawable, null, null, null);
        this.mLeftSecondView.setSelected(false);
    }

    public void setLeftSecondViewImageSrcPadding(int i) {
        this.mLeftSecondView.setCompoundDrawablePadding(i);
    }

    public void setLeftSecondViewText(String str) {
        if (this.mLeftSecondView.getVisibility() == 0) {
            this.mLeftSecondView.setText(str);
        }
    }

    public void setLeftSecondViewTextSize(int i) {
        if (this.mLeftSecondView.getVisibility() == 0) {
            this.mLeftSecondView.setTextSize(i);
        }
    }

    public void setLeftSecondViewVisibility(int i) {
        if (this.mLeftSecondView.getVisibility() == i) {
            return;
        }
        this.mLeftSecondView.setVisibility(i);
        resetCenterTextViewPadding(this.mTitleText);
    }

    public void setLeftTitle(String str) {
        this.mLeftFirstView.setText(str);
    }

    public void setLeftTitleInvalidate(boolean z) {
        this.mIsLeftTitleInvalidate = z;
    }

    public void setLeftZoneImageSelected(boolean z) {
        this.mLeftFirstView.setSelected(z);
    }

    public void setLeftZoneImageSrc(int i) {
        Drawable drawable;
        this.mLeftFirstViewImageSrcId = i;
        if (i != 0) {
            drawable = getResources().getDrawable(i);
        } else {
            drawable = null;
        }
        Drawable scaledDrawable = FontSizeHelper.getScaledDrawable(this.mScaledType, drawable);
        if (scaledDrawable != null) {
            scaledDrawable.setBounds(0, 0, scaledDrawable.getIntrinsicWidth(), scaledDrawable.getIntrinsicHeight());
        }
        this.mLeftFirstView.setCompoundDrawables(scaledDrawable, null, null, null);
        this.mLeftFirstView.setSelected(false);
    }

    public void setLeftZoneImageSrcMinWidth(int i) {
        this.mLeftFirstView.setMinimumWidth(i);
    }

    public void setLeftZoneImageSrcPadding(int i) {
        this.mLeftFirstView.setCompoundDrawablePadding(i);
    }

    public void setLeftZoneOnClickListener(View.OnClickListener onClickListener) {
        this.mLeftFirstView.setOnClickListener(onClickListener);
    }

    public void setLeftZonesVisibility(int i) {
        this.mLeftZones.setVisibility(i);
    }

    public void setOnDoubleClickListener(OnDoubleClickListener onDoubleClickListener) {
        this.mDoubleClickListener = onDoubleClickListener;
    }

    public void setOnMenuItemClickListener(BdMenuItem.OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
        CommonOverflowMenu commonOverflowMenu = this.mMenu;
        if (commonOverflowMenu != null) {
            commonOverflowMenu.setMenuItemClickListener(onItemClickListener);
        }
    }

    public void setOnMenuItemsUpdateListener(BdMenu.OnMenuItemsUpdateListener onMenuItemsUpdateListener) {
        this.mMenuItemsUpdateListener = onMenuItemsUpdateListener;
    }

    public void setRightImageZone1Params(LinearLayout.LayoutParams layoutParams) {
        this.mRightImgZone1.setLayoutParams(layoutParams);
    }

    public void setRightImgZone1ContentDes(String str) {
        this.mRightImgZone1.setContentDescription(str);
    }

    public void setRightImgZone1Enable(boolean z) {
        this.mRightImgZone1.setEnabled(z);
    }

    public void setRightImgZone1ImageScaleType(ImageView.ScaleType scaleType) {
        this.mRightImgZone1Image.setScaleType(scaleType);
    }

    public void setRightImgZone1ImageSrc(int i) {
        setRightImgZone1ImageSrc(i, null);
    }

    public void setRightImgZone1OnClickListener(View.OnClickListener onClickListener) {
        this.mRightImgZone1.setOnClickListener(onClickListener);
    }

    @Deprecated(message = "请使用 setRightImgZone1ImageSrc 方法")
    public void setRightImgZone1Src(int i) {
        setRightImgZone1ImageSrc(i);
    }

    public void setRightImgZone1Visibility(int i) {
        this.mRightImgZone1.setVisibility(i);
    }

    public void setRightImgZone2ContentDes(String str) {
        this.mRightImgZone2.setContentDescription(str);
    }

    public void setRightImgZone2Enable(boolean z) {
        this.mRightImgZone2Image.setEnabled(z);
        this.mRightImgZone2.setEnabled(z);
    }

    public void setRightImgZone2ImageScaleType(ImageView.ScaleType scaleType) {
        this.mRightImgZone2Image.setScaleType(scaleType);
    }

    public void setRightImgZone2ImageSrc(Drawable drawable) {
        this.mRightImgZone2ImageSrcId = 0;
        this.mRightImgZone2ImageSrc = drawable;
        updateImageViewFontSize(this.mRightImgZone2Image, 0, drawable);
    }

    public void setRightImgZone2ImgWidth(int i) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mRightImgZone2Image.getLayoutParams();
        layoutParams.height = i;
        layoutParams.width = i;
        this.mRightImgZone2Image.setLayoutParams(layoutParams);
    }

    public void setRightImgZone2NotifyVisibility(int i) {
        this.mRightImgZone2Notify.setVisibility(i);
    }

    public void setRightImgZone2OnClickListener(View.OnClickListener onClickListener) {
        this.mRightImgZone2.setOnClickListener(onClickListener);
    }

    public void setRightImgZone2Src(int i) {
        this.mRightImgZone2ImageSrcId = i;
        this.mRightImgZone2ImageSrc = null;
        updateImageViewFontSize(this.mRightImgZone2Image, i, null);
    }

    public void setRightImgZone2Url(String str) {
        this.mRightImgZone2Image.setImageURI(Uri.parse(str));
    }

    public void setRightImgZone2Visibility(int i) {
        this.mRightImgZone2.setVisibility(i);
    }

    public void setRightImgZone2Width(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mRightImgZone2.getLayoutParams();
        layoutParams.width = i;
        layoutParams.gravity = 16;
        this.mRightImgZone2.setLayoutParams(layoutParams);
    }

    public void setRightMenuClickListner(View.OnClickListener onClickListener) {
        this.mRightMenu.setOnClickListener(onClickListener);
    }

    public void setRightMenuImageSrc(int i) {
        this.mRightMenuImageViewSrcId = i;
        if (this.mIsResponseFontSizeScale) {
            FontSizeImageViewExtKt.setScaledImageDrawableRes(this.mRightMenuImageView, this.mScaledType, i);
        } else {
            this.mRightMenuImageView.setImageDrawable(ResourcesCompat.getDrawable(getResources(), i, null));
        }
    }

    public void setRightMenuVisibility(int i) {
        this.mRightMenu.setVisibility(i);
    }

    public void setRightTipsStatus(boolean z) {
        int i;
        BdBaseImageView bdBaseImageView = this.mRightImgZone2Tips;
        if (z) {
            i = 0;
        } else {
            i = 8;
        }
        bdBaseImageView.setVisibility(i);
    }

    public void setRightTxt1OnClickListener(View.OnClickListener onClickListener) {
        this.mRightTxtZone1Text.setOnClickListener(onClickListener);
    }

    public void setRightTxtZone1Background(int i) {
        this.mRightTxtZone1.setBackgroundResource(i);
    }

    public void setRightTxtZone1Clickable(boolean z) {
        this.mRightTxtZone1.setClickable(z);
        this.mRightTxtZone1Text.setEnabled(z);
    }

    public void setRightTxtZone1Enable(boolean z) {
        this.mRightTxtZone1.setEnabled(z);
    }

    public void setRightTxtZone1OnClickListener(View.OnClickListener onClickListener) {
        this.mRightTxtZone1.setOnClickListener(onClickListener);
    }

    public void setRightTxtZone1Text(int i) {
        this.mRightTxtZone1Text.setText(i);
    }

    public void setRightTxtZone1TextColor(int i) {
        this.mRightTxtZone1Text.setTextColor(i);
    }

    public void setRightTxtZone1TextColorList(ColorStateList colorStateList) {
        this.mRightTxtZone1Text.setTextColor(colorStateList);
    }

    public void setRightTxtZone1TextSelector(ColorStateList colorStateList) {
        TextView textView = this.mRightTxtZone1Text;
        if (textView == null) {
            return;
        }
        textView.setTextColor(colorStateList);
    }

    public void setRightTxtZone1TextSize(int i) {
        this.mRightTxtZone1Text.setTextSize(0, i);
    }

    public void setRightTxtZone1Visibility(int i) {
        if (i == 0) {
            this.mRightZones.setVisibility(0);
        }
        this.mRightTxtZone1.setVisibility(i);
    }

    public void setRightTxtZone2OnClickListener(View.OnClickListener onClickListener) {
        this.mRightTxtZone2.setOnClickListener(onClickListener);
    }

    public void setRightTxtZone2Text(int i) {
        this.mRightTxtZone2Text.setText(i);
    }

    public void setRightTxtZone2TextColor(int i) {
        this.mRightTxtZone2Text.setTextColor(i);
    }

    public void setRightTxtZone2TextSize(int i) {
        this.mRightTxtZone2Text.setTextSize(0, i);
    }

    public void setRightTxtZone2Visibility(int i) {
        if (i == 0) {
            this.mRightZones.setVisibility(0);
        }
        this.mRightTxtZone2.setVisibility(i);
    }

    public void setRightZone2ImageVisibility(int i) {
        this.mRightImgZone2Image.setVisibility(i);
    }

    public void setRightZonesVisibility(int i) {
        View view2 = this.mRightZones;
        if (view2 != null) {
            view2.setVisibility(i);
        }
    }

    public void setSubTitle(int i) {
        setSubTitle(getResources().getString(i));
    }

    public void setSubTitleColor(int i) {
        this.mSubTitleViewCenter.setTextColor(i);
    }

    public void setTemplate(ActionbarTemplate actionbarTemplate) {
        if (actionbarTemplate == null) {
            return;
        }
        int i = AnonymousClass5.$SwitchMap$com$baidu$searchbox$ui$BdActionBar$ActionbarTemplate[actionbarTemplate.ordinal()];
        if (i != 1) {
            if (i == 2) {
                setTitleColor(com.baidu.tieba.R.color.obfuscated_res_0x7f06018b);
                setRightMenuImageSrc(com.baidu.tieba.R.drawable.obfuscated_res_0x7f0800d0);
                return;
            }
            return;
        }
        setTitleColor(com.baidu.tieba.R.color.obfuscated_res_0x7f060ba7);
        setRightMenuImageSrc(com.baidu.tieba.R.drawable.obfuscated_res_0x7f0800d3);
    }

    public void setTitle(int i) {
        setTitle(getResources().getString(i));
    }

    public void setTitleAlignment(int i) {
        this.mTitleAlignment = i;
        setTitle(this.mTitleText);
    }

    public void setTitleBarTitleSize(float f) {
        this.mTitleViewCenter.setTextSize(0, f);
    }

    public void setTitleColor(int i) {
        this.mTitleColorId = i;
        this.mTitleViewCenter.setTextColor(getResources().getColor(i));
    }

    public void setTitleSize(int i) {
        this.mLeftFirstView.setTextSize(0, i);
    }

    public void setTxtZoneBackgroundMinimumHeight(int i) {
        this.mRightTxtZone1.setMinimumHeight(i);
    }

    public void setTxtZoneBackgroundMinimumWidth(int i) {
        this.mRightTxtZone1.setMinimumWidth(i);
    }

    public void setTxtZoneBackgroundResource(int i) {
        this.mRightTxtZone1.setBackground(getResources().getDrawable(i));
        this.mRightTxtZone2.setBackground(getResources().getDrawable(i));
    }

    public BdActionBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isLeftBack = true;
        this.mRightTxtZone1TxtColor = -1;
        this.mScaledType = 0;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.searchbox.ui.BdActionBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                BdActionBar.this.toggleMenu();
            }
        };
        this.mRightTxtZone2TxtColor = -1;
        this.mIsResponseFontSizeScale = true;
        initAttrs(context, attributeSet);
        init();
    }

    private void setRightImgZone1ImageSrc(int i, Drawable drawable) {
        this.mRightImgZone1ImageSrcId = i;
        this.mRightImgZone1ImageSrc = drawable;
        updateImageViewFontSize(this.mRightImgZone1Image, i, drawable);
    }

    private void updateTextViewFontSize(TextView textView, @DimenRes int i) {
        FontSizeTextViewExtKt.setScaledSizeRes(textView, this.mScaledType, i);
    }

    public BdActionBar add(int i, int i2) {
        initMenu();
        this.mMenu.add(i, i2);
        return this;
    }

    public void setRightImageZone1Params(int i, int i2) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mRightImgZone1.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        this.mRightImgZone1.setLayoutParams(layoutParams);
    }

    public void setRightTxtZone1Typeface(Typeface typeface, int i) {
        TextView textView = this.mRightTxtZone1Text;
        if (textView == null) {
            return;
        }
        textView.setTypeface(typeface, i);
    }

    public void setTitleTypeface(Typeface typeface, int i) {
        this.mTitleViewCenter.setTypeface(typeface, i);
    }

    public BdActionBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isLeftBack = true;
        this.mRightTxtZone1TxtColor = -1;
        this.mScaledType = 0;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.searchbox.ui.BdActionBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                BdActionBar.this.toggleMenu();
            }
        };
        this.mRightTxtZone2TxtColor = -1;
        this.mIsResponseFontSizeScale = true;
        initAttrs(context, attributeSet);
        init();
    }

    private void updateImageViewFontSize(ImageView imageView, int i, Drawable drawable) {
        if (imageView == null) {
            return;
        }
        if (i != 0) {
            if (this.mIsResponseFontSizeScale) {
                FontSizeImageViewExtKt.setScaledImageDrawableRes(imageView, this.mScaledType, i);
            } else {
                imageView.setImageDrawable(ResourcesCompat.getDrawable(getResources(), i, null));
            }
        } else if (drawable != null) {
            if (this.mIsResponseFontSizeScale) {
                FontSizeImageViewExtKt.setScaledImageDrawable(imageView, this.mScaledType, drawable);
            } else {
                imageView.setImageDrawable(drawable);
            }
        }
    }

    public BdActionBar add(int i, int i2, int i3) {
        initMenu();
        this.mMenu.add(i, i2, i3);
        return this;
    }

    public void setLeftSecondViewImageSrc(int i, int i2, int i3) {
        Drawable drawable;
        if (i != 0) {
            drawable = getResources().getDrawable(i);
        } else {
            drawable = null;
        }
        if (drawable != null) {
            drawable.setBounds(0, 0, i2, i3);
        }
        this.mLeftSecondView.setCompoundDrawables(drawable, null, null, null);
        this.mLeftSecondView.setSelected(false);
    }

    public void setLeftZoneImageSrc(int i, int i2, int i3) {
        Drawable drawable;
        if (i != 0) {
            drawable = getResources().getDrawable(i);
        } else {
            drawable = null;
        }
        if (drawable != null) {
            drawable.setBounds(0, 0, i2, i3);
        }
        this.mLeftFirstView.setCompoundDrawables(drawable, null, null, null);
        this.mLeftFirstView.setSelected(false);
    }

    public void setRightImgZone2Params(int i, int i2, int i3) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mRightImgZone2Image.getLayoutParams();
        layoutParams.leftMargin = i;
        layoutParams.rightMargin = i2;
        layoutParams.bottomMargin = i3;
        layoutParams.topMargin = i3;
        this.mRightImgZone2Image.setLayoutParams(layoutParams);
    }

    public BdActionBar(Context context, AttributeSet attributeSet, int i, boolean z) {
        super(context, attributeSet, i);
        this.isLeftBack = true;
        this.mRightTxtZone1TxtColor = -1;
        this.mScaledType = 0;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.searchbox.ui.BdActionBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                BdActionBar.this.toggleMenu();
            }
        };
        this.mRightTxtZone2TxtColor = -1;
        this.mIsResponseFontSizeScale = true;
        this.mIsResponseFontSizeScale = z;
        if (!z) {
            this.mScaledType = -1;
        }
        initAttrs(context, attributeSet);
        init();
    }

    public void setTitlePadding(int i, int i2, int i3, int i4) {
        this.mLeftFirstView.setPadding(i, i2, i3, i4);
    }

    public void setTitleShadowLayer(float f, float f2, float f3, int i) {
        this.mLeftFirstView.setShadowLayer(f, f2, f3, i);
        this.mTitleViewCenter.setShadowLayer(f, f2, f3, i);
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(com.baidu.tieba.R.layout.obfuscated_res_0x7f0d0026, this);
        this.mLeftCustomLayout = (FrameLayout) findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f0914d6);
        TextView textView = (TextView) findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f0914d8);
        this.mLeftFirstView = textView;
        textView.setCompoundDrawables(getDrawableFromId(com.baidu.tieba.R.drawable.obfuscated_res_0x7f0800cc), null, null, null);
        this.mLeftFirstViewImageSrcId = com.baidu.tieba.R.drawable.obfuscated_res_0x7f0800cc;
        this.mLeftFirstView.setTextColor(getResources().getColorStateList(com.baidu.tieba.R.color.obfuscated_res_0x7f0603e6));
        this.mTitleViewCenter = (TextView) findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f092588);
        TextView textView2 = (TextView) findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f0922df);
        this.mSubTitleViewCenter = textView2;
        textView2.setTextColor(getResources().getColor(com.baidu.tieba.R.color.obfuscated_res_0x7f060ba7));
        TextView textView3 = (TextView) findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f0914e2);
        this.mLeftSecondView = textView3;
        textView3.setTextColor(getResources().getColorStateList(com.baidu.tieba.R.color.obfuscated_res_0x7f0603e6));
        float f = this.mTitleTxtShadowDx;
        if (f != -1.0f) {
            float f2 = this.mTitleTxtShadowDy;
            if (f2 != -1.0f) {
                float f3 = this.mTitleTxtShadowRadius;
                if (f3 != -1.0f) {
                    this.mLeftFirstView.setShadowLayer(f3, f, f2, this.mTitleTxtShadowColor);
                }
            }
        }
        View findViewById = findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f0925aa);
        this.mRightTxtZone2 = findViewById;
        findViewById.setVisibility(VISIBILITY_FLAGS[this.mRightTxtZone2Visibility]);
        TextView textView4 = (TextView) findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f0925ab);
        this.mRightTxtZone2Text = textView4;
        String str = this.mRightTxtZone2TextString;
        if (str != null) {
            textView4.setText(str);
        }
        int i = this.mRightTxtZone2TxtColor;
        if (i != -1) {
            this.mRightTxtZone2Text.setTextColor(i);
        } else {
            this.mRightTxtZone2Text.setTextColor(getResources().getColorStateList(com.baidu.tieba.R.color.obfuscated_res_0x7f0603e6));
        }
        View findViewById2 = findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f0925a7);
        this.mRightTxtZone1 = findViewById2;
        findViewById2.setVisibility(VISIBILITY_FLAGS[this.mRightTxtZone1Visibility]);
        TextView textView5 = (TextView) findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f0925a9);
        this.mRightTxtZone1Text = textView5;
        String str2 = this.mRightTxtZone1TextString;
        if (str2 != null) {
            textView5.setText(str2);
        }
        int i2 = this.mRightTxtZone1TxtColor;
        if (i2 != -1) {
            this.mRightTxtZone1Text.setTextColor(i2);
        } else {
            this.mRightTxtZone1Text.setTextColor(getResources().getColorStateList(com.baidu.tieba.R.color.obfuscated_res_0x7f0603e6));
        }
        this.mRightTxtZone1Progress = (ProgressBar) findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f0925a8);
        this.mRightImgZone2Image = (BdBaseImageView) findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f09259e);
        this.mRightImgZone2Tips = (BdBaseImageView) findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f091925);
        View findViewById3 = findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f09259d);
        this.mRightImgZone2 = findViewById3;
        findViewById3.setVisibility(VISIBILITY_FLAGS[this.mRightImgZone2Visibility]);
        this.mRightImgZone1Image = (BdBaseImageView) findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f09259c);
        View findViewById4 = findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f09259b);
        this.mRightImgZone1 = findViewById4;
        findViewById4.setVisibility(VISIBILITY_FLAGS[this.mRightImgZone1Visibility]);
        View findViewById5 = findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f0925ac);
        this.mRightZones = findViewById5;
        findViewById5.setVisibility(VISIBILITY_FLAGS[this.mRightZonesVisibility]);
        this.mLeftZones = findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f09259a);
        this.mRightImgZone2Notify = findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f09259f);
        this.mRightMenu = findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f0925a1);
        this.mRightMenuImageView = (ImageView) findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f0925a3);
        this.mRightMenu.setOnClickListener(this.mOnClickListener);
        setTitleAlignment(1);
        setTitle(this.mTitleText);
        setTitleColor(com.baidu.tieba.R.color.obfuscated_res_0x7f06018b);
        setRightMenuImageSrc(com.baidu.tieba.R.drawable.obfuscated_res_0x7f0800d3);
        setRightImgZone2Src(com.baidu.tieba.R.drawable.obfuscated_res_0x7f0800c8);
        setRightImgZone1Src(com.baidu.tieba.R.drawable.obfuscated_res_0x7f0800c9);
        final GestureDetector gestureDetector = new GestureDetector(getContext(), new GestureListener());
        setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.searchbox.ui.BdActionBar.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                return gestureDetector.onTouchEvent(motionEvent);
            }
        });
        onFontSizeChange();
    }

    private void initAttrs(Context context, AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, com.baidu.android.common.ui.style.R.styleable.BdActionBar, 0, 0);
        try {
            this.mTitleText = obtainStyledAttributes.getString(15);
            this.mTitleTxtShadowColor = obtainStyledAttributes.getColor(16, -16777216);
            this.mTitleTxtShadowDx = obtainStyledAttributes.getFloat(17, -1.0f);
            this.mTitleTxtShadowDy = obtainStyledAttributes.getFloat(18, -1.0f);
            this.mTitleTxtShadowRadius = obtainStyledAttributes.getFloat(19, -1.0f);
            this.mRightTxtZone2Visibility = obtainStyledAttributes.getInt(11, 0);
            this.mRightTxtZone2TextString = obtainStyledAttributes.getString(4);
            this.mRightTxtZone1Visibility = obtainStyledAttributes.getInt(11, 0);
            this.mRightTxtZone1TextString = obtainStyledAttributes.getString(4);
            this.mRightImgZone2ImageSrc = obtainStyledAttributes.getDrawable(2);
            this.mRightZonesVisibility = obtainStyledAttributes.getInt(12, 0);
            this.mRightImgZone1ImageSrc = obtainStyledAttributes.getDrawable(0);
            this.mRightImgZone1Visibility = obtainStyledAttributes.getInt(1, 0);
            this.mRightImgZone2Visibility = obtainStyledAttributes.getInt(3, 0);
            this.mRightTxtZone1TxtColor = obtainStyledAttributes.getColor(5, getResources().getColor(com.baidu.tieba.R.color.obfuscated_res_0x7f0603e7));
            this.mTitleAlignment = obtainStyledAttributes.getInt(13, 1);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public BdActionBar add(int i, CharSequence charSequence) {
        initMenu();
        this.mMenu.add(i, charSequence);
        return this;
    }

    public BdActionBar add(int i, CharSequence charSequence, Drawable drawable) {
        initMenu();
        this.mMenu.add(i, charSequence, drawable);
        return this;
    }

    public void applyServerConfig(int i) {
        if (i != Integer.MAX_VALUE) {
            if (BarSwitches.getActionBarSwitch(i)) {
                setVisibility(0);
                if (BarSwitches.getMenuSwitch(i)) {
                    this.mRightMenu.setVisibility(0);
                } else {
                    this.mRightMenu.setVisibility(8);
                }
                if (BarSwitches.getTitleSwitch(i)) {
                    this.mTitleViewCenter.setVisibility(0);
                    return;
                } else {
                    this.mTitleViewCenter.setVisibility(4);
                    return;
                }
            }
            setVisibility(8);
        }
    }

    public void setImgZoneBackgroundResource(int i) {
        this.mLeftFirstView.setBackground(getResources().getDrawable(i));
        this.mRightImgZone1.setBackground(getResources().getDrawable(i));
        this.mRightImgZone2.setBackground(getResources().getDrawable(i));
        this.mLeftSecondView.setBackground(getResources().getDrawable(i));
    }

    public void onFontSizeChange() {
        FontSizeViewExtKt.setScaledSizeRes(this.mRightMenuImageView, this.mScaledType, com.baidu.tieba.R.dimen.obfuscated_res_0x7f0702ea, com.baidu.tieba.R.dimen.obfuscated_res_0x7f0702ea);
        FontSizeTextViewExtKt.setScaledSizeRes(this.mTitleViewCenter, this.mScaledType, com.baidu.tieba.R.dimen.obfuscated_res_0x7f0702e7);
        FontSizeTextViewExtKt.setScaledSizeRes(this.mSubTitleViewCenter, this.mScaledType, com.baidu.tieba.R.dimen.obfuscated_res_0x7f0702e3);
        FontSizeTextViewExtKt.setScaledSizeRes(this.mRightTxtZone2Text, this.mScaledType, com.baidu.tieba.R.dimen.obfuscated_res_0x7f0702e5);
        FontSizeViewExtKt.setScaledSizeRes(this.mRightTxtZone1Progress, this.mScaledType, com.baidu.tieba.R.dimen.obfuscated_res_0x7f0702e9, com.baidu.tieba.R.dimen.obfuscated_res_0x7f0702e9);
        updateTextViewFontSize(this.mLeftFirstView, com.baidu.tieba.R.dimen.obfuscated_res_0x7f0702e5);
        setLeftZoneImageSrc(this.mLeftFirstViewImageSrcId);
        updateTextViewFontSize(this.mRightTxtZone1Text, com.baidu.tieba.R.dimen.obfuscated_res_0x7f0702e5);
        updateTextViewFontSize(this.mLeftSecondView, com.baidu.tieba.R.dimen.obfuscated_res_0x7f0702e7);
        updateImageViewFontSize(this.mRightImgZone1Image, this.mRightImgZone1ImageSrcId, this.mRightImgZone1ImageSrc);
        updateImageViewFontSize(this.mRightImgZone2Image, this.mRightImgZone2ImageSrcId, this.mRightImgZone2ImageSrc);
        updateImageViewFontSize(this.mRightImgZone2Tips);
    }

    public boolean toggleMenu() {
        if (this.mMenu == null) {
            return false;
        }
        int[] iArr = new int[2];
        this.mRightMenu.getLocationInWindow(iArr);
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(com.baidu.tieba.R.dimen.obfuscated_res_0x7f0700e0);
        int height = iArr[1] + this.mRightMenu.getHeight() + getContext().getResources().getDimensionPixelSize(com.baidu.tieba.R.dimen.obfuscated_res_0x7f0700e1);
        this.mMenu.getView().getWidth();
        this.mMenu.setShowAtLocation(0, (DeviceUtil.ScreenInfo.getDisplayWidth(getContext()) - dimensionPixelSize) - this.mMenu.getView().getWidth(), height);
        this.mMenu.toggle();
        return true;
    }

    public void setLeftFirstViewVisibility(boolean z) {
        TextView textView = this.mLeftFirstView;
        if (textView != null) {
            if (z) {
                textView.setVisibility(0);
            } else {
                textView.setVisibility(4);
            }
        }
    }

    public void setRightImgZone1ImageSrc(Drawable drawable) {
        setRightImgZone1ImageSrc(0, drawable);
    }

    public void setRightTxtZone1Text(CharSequence charSequence) {
        this.mRightTxtZone1Text.setText(charSequence);
    }

    public void setSubTitle(String str) {
        this.mSubTitleText = str;
        if (TextUtils.isEmpty(str)) {
            this.mSubTitleViewCenter.setVisibility(8);
        } else {
            this.mSubTitleViewCenter.setVisibility(0);
        }
        int i = this.mTitleAlignment;
        if (1 == i) {
            this.mSubTitleViewCenter.setText(str);
        } else if (i == 0) {
            this.mSubTitleViewCenter.setText((CharSequence) null);
        }
        invalidate();
    }

    public void setTitle(String str) {
        this.mTitleText = str;
        int i = this.mTitleAlignment;
        if (1 == i) {
            this.mTitleViewCenter.setText(str);
            if (this.mIsLeftTitleInvalidate) {
                resetCenterTextViewPadding(str);
            } else {
                this.mLeftFirstView.setText((CharSequence) null);
            }
        } else if (i == 0) {
            this.mLeftFirstView.setText(str);
            this.mTitleViewCenter.setText((CharSequence) null);
        }
        invalidate();
    }
}
