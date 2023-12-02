package com.baidu.searchbox.toolbar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.config.FontSizeHelper;
import com.baidu.searchbox.toolbar.PraiseToolBarItem;
import com.baidu.searchbox.ui.BdBaseImageView;
import com.baidu.searchbox.ui.CoolPraiseView;
import com.baidu.searchbox.ui.SelectorTextView;
import com.baidu.searchbox.ui.animview.praise.data.PraiseSourceDef;
import com.baidu.searchbox.ui.animview.util.PraiseUBCHelper;
import com.baidu.searchbox.ui.fontsize.view.FontSizeImageView;
import com.baidu.searchbox.ui.view.BadgeFactory;
import com.baidu.searchbox.ui.view.BadgeView;
import com.baidu.spswitch.emotion.EmotionLoader;
import com.baidu.spswitch.emotion.EmotionType;
import com.baidu.tieba.R;
import com.baidu.ubc.UBCManager;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes4.dex */
public class CommonToolBar extends BaseToolBar {
    public static String sKeyMoreViewPop = "hadShowedMoreViewPop";
    public boolean isIncognito;
    public String mDefaultInput;
    public boolean mEnableSoFa;
    public boolean mIsCloseComment;
    public boolean mIsMiniVideoRightInteraction;
    public boolean mIsMiniVideoUISet;
    public boolean mIsMiniVideoVerticalLandingStyle;
    public boolean mIsRecommended;
    public boolean mIsSoFa;
    public BadgeView mMenuBadgeView;
    public MenuTipsHelper mMenuTipsHelper;
    public ToolbarMode mMode;
    public String mStatisticSource;

    /* loaded from: classes4.dex */
    public enum ToolbarMode {
        NORMAL,
        DARK
    }

    public void startCommentInputAnim() {
    }

    /* renamed from: com.baidu.searchbox.toolbar.CommonToolBar$5  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass5 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$searchbox$toolbar$PraiseToolBarItem$PraiseIconType;

        static {
            int[] iArr = new int[PraiseToolBarItem.PraiseIconType.values().length];
            $SwitchMap$com$baidu$searchbox$toolbar$PraiseToolBarItem$PraiseIconType = iArr;
            try {
                iArr[PraiseToolBarItem.PraiseIconType.HEARTS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$toolbar$PraiseToolBarItem$PraiseIconType[PraiseToolBarItem.PraiseIconType.CUSTOM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public CommonToolBar(Context context, List<BaseToolBarItem> list, ToolbarMode toolbarMode) {
        super(context, list);
        this.isIncognito = false;
        this.mIsCloseComment = false;
        this.mEnableSoFa = true;
        this.mIsSoFa = false;
        this.mIsMiniVideoRightInteraction = false;
        this.mIsMiniVideoUISet = false;
        this.mIsMiniVideoVerticalLandingStyle = false;
        this.mIsRecommended = false;
        this.mMode = toolbarMode;
        init();
    }

    public void configMenuTips(int i, boolean z, int i2) {
        if (this.mMenuTipsHelper == null) {
            this.mMenuTipsHelper = new MenuTipsHelper();
        }
        this.mMenuTipsHelper.refreshMenuTips(i, z, i2);
        configBadgeView(this.mMenuTipsHelper.isShowMenuTips(), this.mMenuTipsHelper.getMenuTipsCount());
    }

    public CommonToolBar(Context context, List<BaseToolBarItem> list, ToolbarMode toolbarMode, boolean z) {
        super(context, list, z);
        this.isIncognito = false;
        this.mIsCloseComment = false;
        this.mEnableSoFa = true;
        this.mIsSoFa = false;
        this.mIsMiniVideoRightInteraction = false;
        this.mIsMiniVideoUISet = false;
        this.mIsMiniVideoVerticalLandingStyle = false;
        this.mIsRecommended = false;
        this.mMode = toolbarMode;
        init();
    }

    public CommonToolBar(Context context, List<BaseToolBarItem> list, ToolbarMode toolbarMode, boolean z, boolean z2) {
        super(context, list, z, z2);
        this.isIncognito = false;
        this.mIsCloseComment = false;
        this.mEnableSoFa = true;
        this.mIsSoFa = false;
        this.mIsMiniVideoRightInteraction = false;
        this.mIsMiniVideoUISet = false;
        this.mIsMiniVideoVerticalLandingStyle = false;
        this.mIsRecommended = false;
        this.mMode = toolbarMode;
        init();
    }

    private void configBadgeView(boolean z, int i) {
        BadgeView badgeView;
        View toolBarItemView = getToolBarItemView(17);
        if (toolBarItemView != null && toolBarItemView.getVisibility() == 0) {
            if (z && ((badgeView = this.mMenuBadgeView) == null || badgeView.getVisibility() != 0)) {
                HashMap hashMap = new HashMap();
                hashMap.put("from", "tool");
                hashMap.put("type", CommonToolbarStatisticConstants.TOOLBAR_MENU_TYPE_NEW_TIPS);
                ((UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).onEvent(CommonToolbarStatisticConstants.TOOLBAR_MENU_STAT_KEY_MENU, hashMap);
            }
            BadgeView badgeView2 = this.mMenuBadgeView;
            if (badgeView2 == null) {
                BadgeView createBadgeView = BadgeFactory.createBadgeView(getContext(), BadgeView.Type.DOT);
                this.mMenuBadgeView = createBadgeView;
                createBadgeView.bindView(toolBarItemView);
            } else {
                badgeView2.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f06048c));
                this.mMenuBadgeView.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.obfuscated_res_0x7f08051a, null));
            }
            if (z) {
                this.mMenuBadgeView.setBadgeMarginInPx(0, getSkinStyleBadgeTopMargin(), getSkinStyleBadgeRightMargin(), 0);
                this.mMenuBadgeView.setVisibility(0);
                return;
            }
            this.mMenuBadgeView.setVisibility(8);
        }
    }

    private int getSkinStyleBadgeRightMargin() {
        int i;
        int i2;
        int i3;
        int i4;
        int scaledSize = (int) FontSizeHelper.getScaledSize(0, 57.0f);
        BadgeView badgeView = this.mMenuBadgeView;
        if (badgeView != null) {
            i = badgeView.getWidth();
        } else {
            i = 0;
        }
        View toolBarItemView = getToolBarItemView(17);
        if (toolBarItemView != null) {
            i2 = toolBarItemView.getWidth();
            i4 = toolBarItemView.getPaddingLeft();
            i3 = toolBarItemView.getPaddingRight();
        } else {
            i2 = scaledSize;
            i3 = 0;
            i4 = 0;
        }
        if (AppConfig.isDebug()) {
            Log.d("CommonToolBar", "getSkinStyleBadgeRightMargin iconSize:" + scaledSize + " ,viewWidth:" + i2 + " ,badgeWidth:" + i + ", paddingLeft:" + i4 + " ,paddingRight:" + i3);
        }
        return i2 - (((((i2 - i4) - i3) / 2) + (scaledSize / 2)) + i);
    }

    public void setCloseCommentUIForAtlas() {
        SelectorTextView commentInputView;
        this.mIsCloseComment = true;
        View toolBarItemView = getToolBarItemView(7);
        if (toolBarItemView instanceof CommentRedTipLayout) {
            CommentRedTipLayout commentRedTipLayout = (CommentRedTipLayout) toolBarItemView;
            commentRedTipLayout.getCommentsView().setEnabled(false);
            commentRedTipLayout.getCommentsView().setIconEnable(false);
            commentRedTipLayout.getCommentsView().setIcon(R.drawable.obfuscated_res_0x7f080536);
            commentRedTipLayout.setCommentsStatus(this, ToolBarNewType.NO_TIP, "");
        }
        CommentInputLayout commentInputLayout = (CommentInputLayout) getToolBarItemView(10);
        if (commentInputLayout != null && (commentInputView = commentInputLayout.getCommentInputView()) != null) {
            commentInputView.setEnabled(false);
            commentInputView.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f06064e));
            commentInputView.setPadding((int) getResources().getDimension(R.dimen.obfuscated_res_0x7f07025d), 0, (int) getResources().getDimension(R.dimen.obfuscated_res_0x7f07025d), 0);
        }
    }

    public void setCloseCommentUIForMiniVideo() {
        this.mIsCloseComment = true;
        View toolBarItemView = getToolBarItemView(7);
        if (toolBarItemView instanceof CommentRedTipLayout) {
            CommentRedTipLayout commentRedTipLayout = (CommentRedTipLayout) toolBarItemView;
            commentRedTipLayout.getCommentsView().setEnabled(false);
            commentRedTipLayout.getCommentsView().setIconEnable(false);
            commentRedTipLayout.getCommentsView().setIcon(R.drawable.obfuscated_res_0x7f080535);
            commentRedTipLayout.setCommentsStatus(this, ToolBarNewType.NO_TIP, "");
        }
        CommentInputLayout commentInputLayout = (CommentInputLayout) getToolBarItemView(10);
        if (commentInputLayout != null) {
            SelectorTextView commentInputView = commentInputLayout.getCommentInputView();
            if (commentInputView != null) {
                commentInputView.setEnabled(false);
                commentInputView.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f06064d));
                commentInputView.setPadding((int) getResources().getDimension(R.dimen.obfuscated_res_0x7f07025d), 0, (int) getResources().getDimension(R.dimen.obfuscated_res_0x7f07025d), 0);
            }
            SelectorImageView commentEmojiIcon = commentInputLayout.getCommentEmojiIcon();
            if (commentEmojiIcon != null) {
                commentEmojiIcon.setVisibility(8);
            }
        }
    }

    public void setCloseCommentUIForNews() {
        this.mIsCloseComment = true;
        View toolBarItemView = getToolBarItemView(7);
        if (toolBarItemView instanceof CommentRedTipLayout) {
            CommentRedTipLayout commentRedTipLayout = (CommentRedTipLayout) toolBarItemView;
            commentRedTipLayout.getCommentsView().setEnabled(false);
            commentRedTipLayout.getCommentsView().setIconEnable(false);
            commentRedTipLayout.getCommentsView().setIcon(R.drawable.obfuscated_res_0x7f080534);
            commentRedTipLayout.setCommentsStatus(this, ToolBarNewType.NO_TIP, "");
        }
        CommentInputLayout commentInputLayout = (CommentInputLayout) getToolBarItemView(10);
        if (commentInputLayout != null) {
            commentInputLayout.setEnabled(false);
            commentInputLayout.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.obfuscated_res_0x7f081558, null));
            SelectorTextView commentInputView = commentInputLayout.getCommentInputView();
            if (commentInputView != null) {
                commentInputView.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060b6b));
                commentInputView.setPadding((int) getResources().getDimension(R.dimen.obfuscated_res_0x7f07025d), 0, (int) getResources().getDimension(R.dimen.obfuscated_res_0x7f07025d), 0);
            }
        }
    }

    private int getSkinStyleBadgeTopMargin() {
        return ((int) (getContext().getResources().getDimensionPixelOffset(BaseToolBarExtKt.getBarHeightDimens(true)) - (FontSizeHelper.getScaledSize(0, 57.0f) + DeviceUtil.ScreenInfo.dp2px(getContext(), 6.0f)))) / 2;
    }

    private void setDarkUI() {
        setDarkUI(false);
    }

    private void setNormalUI() {
        setNormalUI(false);
    }

    private void updateStarViewMode() {
        View toolBarItemView = getToolBarItemView(8);
        if (toolBarItemView != null) {
            Object tag = toolBarItemView.getTag();
            if (tag instanceof Boolean) {
                setStarStatus(((Boolean) tag).booleanValue());
            } else {
                setStarStatus(false);
            }
        }
    }

    private void updateWendaUI() {
        View toolBarItemView = getToolBarItemView(14);
        if ((toolBarItemView instanceof WendaToolBarItemView) && toolBarItemView.getVisibility() == 0) {
            ((WendaToolBarItemView) toolBarItemView).updateWendaUI();
        }
    }

    public View getBackView() {
        return getToolBarItemView(1);
    }

    @Nullable
    public String getCommentInputContent() {
        CommentInputLayout commentInputLayout = (CommentInputLayout) getToolBarItemView(10);
        if (commentInputLayout != null) {
            if (commentInputLayout.isGuideShowing()) {
                return commentInputLayout.getCommentInputGuide().getText().toString();
            }
            return commentInputLayout.getCommentInputView().getText().toString();
        }
        return null;
    }

    @Nullable
    public TextView getCommentTipsView() {
        View toolBarItemView = getToolBarItemView(7);
        if (toolBarItemView instanceof CommentRedTipLayout) {
            return ((CommentRedTipLayout) toolBarItemView).getCommentTips();
        }
        return null;
    }

    @Nullable
    public RedTipImageView getCommentView() {
        View toolBarItemView = getToolBarItemView(7);
        if (toolBarItemView instanceof CommentRedTipLayout) {
            return ((CommentRedTipLayout) toolBarItemView).getCommentsView();
        }
        return null;
    }

    public View getMoreView() {
        return getToolBarItemView(17);
    }

    public View getMultiWindowView() {
        return getToolBarItemView(16);
    }

    @Nullable
    public PraiseToolBarItem getPraiseToolBarItem() {
        BaseToolBarItem toolBarItem = getToolBarItem(13);
        if (toolBarItem instanceof PraiseToolBarItem) {
            return (PraiseToolBarItem) toolBarItem;
        }
        return null;
    }

    @Nullable
    public CoolPraiseView getPraiseView() {
        View toolBarItemView = getToolBarItemView(13);
        if (toolBarItemView instanceof PraiseToolBarItemView) {
            return ((PraiseToolBarItemView) toolBarItemView).getCoolPraiseView();
        }
        return null;
    }

    public ImageView getShare() {
        View toolBarItemView = getToolBarItemView(9);
        if (toolBarItemView instanceof ImageView) {
            return (ImageView) toolBarItemView;
        }
        return null;
    }

    public String getStatisticSource() {
        return this.mStatisticSource;
    }

    public boolean isCloseComment() {
        return this.mIsCloseComment;
    }

    public boolean isCommentInputInGuide() {
        CommentInputLayout commentInputLayout = (CommentInputLayout) getToolBarItemView(10);
        if (commentInputLayout != null) {
            return commentInputLayout.isGuideShowing();
        }
        return false;
    }

    public boolean isEnableSoFa() {
        return this.mEnableSoFa;
    }

    public boolean isRecommendViewStatus() {
        return this.mIsRecommended;
    }

    public boolean isShowBackPop() {
        View toolBarItemView = getToolBarItemView(1);
        if (toolBarItemView != null) {
            Object tag = toolBarItemView.getTag();
            if (tag instanceof String) {
                return getResources().getString(R.string.obfuscated_res_0x7f0f072f).equals((String) tag);
            }
            return false;
        }
        return false;
    }

    public boolean isSoFa() {
        return this.mIsSoFa;
    }

    @Override // com.baidu.searchbox.toolbar.BaseToolBar
    public void onFontSizeChange() {
        super.onFontSizeChange();
        BadgeView badgeView = this.mMenuBadgeView;
        if (badgeView != null && badgeView.getVisibility() == 0) {
            this.mMenuBadgeView.setBadgeMarginInPx(0, getSkinStyleBadgeTopMargin(), getSkinStyleBadgeRightMargin(), 0);
        }
    }

    public void prepareStarAnim() {
        RedTipImageView redTipImageView = (RedTipImageView) getToolBarItemView(8);
        if (redTipImageView != null) {
            redTipImageView.setCopyIcon();
        }
    }

    public void releaseCommentInput() {
        CommentInputLayout commentInputLayout = (CommentInputLayout) getToolBarItemView(10);
        if (commentInputLayout != null) {
            commentInputLayout.releaseAnim();
        }
    }

    public void setBackGuide() {
        setBackStatus(getResources().getString(R.string.obfuscated_res_0x7f0f072f));
    }

    public void setBackGuideHidden() {
        setBackStatus("");
    }

    public void setOpenCommentUI() {
        this.mIsCloseComment = false;
        View toolBarItemView = getToolBarItemView(7);
        if (toolBarItemView instanceof CommentRedTipLayout) {
            CommentRedTipLayout commentRedTipLayout = (CommentRedTipLayout) toolBarItemView;
            commentRedTipLayout.getCommentsView().setEnabled(true);
            commentRedTipLayout.getCommentsView().setIconEnable(true);
        }
        View toolBarItemView2 = getToolBarItemView(10);
        if (toolBarItemView2 != null) {
            toolBarItemView2.setEnabled(true);
        }
        updateUI();
    }

    public void setOpenCommentUIForMiniVideo() {
        this.mIsCloseComment = false;
        View toolBarItemView = getToolBarItemView(7);
        if (toolBarItemView instanceof CommentRedTipLayout) {
            CommentRedTipLayout commentRedTipLayout = (CommentRedTipLayout) toolBarItemView;
            commentRedTipLayout.getCommentsView().setEnabled(true);
            commentRedTipLayout.getCommentsView().setIconEnable(true);
        }
        View toolBarItemView2 = getToolBarItemView(10);
        if (toolBarItemView2 != null) {
            toolBarItemView2.setEnabled(true);
        }
        setMiniVideoUI();
    }

    public void updateMultiWindowAndMoreViewUI() {
        View toolBarItemView = getToolBarItemView(17);
        if ((toolBarItemView instanceof ImageView) && toolBarItemView.getVisibility() == 0) {
            ((ImageView) toolBarItemView).setImageResource(R.drawable.obfuscated_res_0x7f080540);
        }
    }

    public void updateUI() {
        if (this.mMode == ToolbarMode.DARK) {
            setDarkUI();
        } else {
            setNormalUI();
        }
    }

    private void init() {
        updateUI();
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.searchbox.toolbar.CommonToolBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
            }
        });
        final PraiseToolBarItem praiseToolBarItem = getPraiseToolBarItem();
        if (praiseToolBarItem != null && (praiseToolBarItem.getItemView() instanceof PraiseToolBarItemView)) {
            CoolPraiseView coolPraiseView = ((PraiseToolBarItemView) praiseToolBarItem.getItemView()).getCoolPraiseView();
            if (AnonymousClass5.$SwitchMap$com$baidu$searchbox$toolbar$PraiseToolBarItem$PraiseIconType[praiseToolBarItem.getType().ordinal()] != 1) {
                if (this.mMode == ToolbarMode.DARK) {
                    coolPraiseView.setPraiseStateIconRes(R.drawable.obfuscated_res_0x7f080542, R.drawable.obfuscated_res_0x7f080543);
                } else {
                    coolPraiseView.setPraiseStateIconRes(R.drawable.obfuscated_res_0x7f080541, R.drawable.obfuscated_res_0x7f080543);
                }
            } else {
                coolPraiseView.setPraiseStateIconRes(R.drawable.obfuscated_res_0x7f080518, R.drawable.obfuscated_res_0x7f080517);
            }
            coolPraiseView.setPraise(false);
            coolPraiseView.setPraiseCount(0);
            coolPraiseView.setOnClickPraiseListener(new CoolPraiseView.OnClickPraiseListener() { // from class: com.baidu.searchbox.toolbar.CommonToolBar.2
                @Override // com.baidu.searchbox.ui.CoolPraiseView.OnClickPraiseListener
                public void onClick(boolean z, int i) {
                    if (praiseToolBarItem.getLikeInfo() != null) {
                        praiseToolBarItem.getLikeInfo().isLiked = z;
                        CommonToolBarLikeInfo likeInfo = praiseToolBarItem.getLikeInfo();
                        likeInfo.likeCount = i + "";
                        praiseToolBarItem.getLikeInfo().updateLikeSyncData();
                    }
                    CommonToolBar.this.onClick(praiseToolBarItem.getItemView());
                }
            });
        }
        final BaseToolBarItem toolBarItem = getToolBarItem(10);
        if (toolBarItem != null && (toolBarItem.getItemView() instanceof CommentInputLayout)) {
            ((CommentInputLayout) toolBarItem.getItemView()).getCommentInputView().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.searchbox.toolbar.CommonToolBar.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    CommonToolBar.this.onClick(toolBarItem.getItemView());
                }
            });
        }
        if (toolBarItem != null && (toolBarItem.getItemView() instanceof CommentInputLayout)) {
            ((CommentInputLayout) toolBarItem.getItemView()).getCommentInputGuide().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.searchbox.toolbar.CommonToolBar.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    CommonToolBar.this.onClick(toolBarItem.getItemView());
                }
            });
        }
        setContentDescription();
    }

    private void setContentDescription() {
        View toolBarItemView = getToolBarItemView(1);
        if (toolBarItemView != null) {
            toolBarItemView.setContentDescription(getResources().getString(R.string.obfuscated_res_0x7f0f04b3));
        }
        View toolBarItemView2 = getToolBarItemView(4);
        if (toolBarItemView2 != null) {
            toolBarItemView2.setContentDescription(getResources().getString(R.string.obfuscated_res_0x7f0f04b9));
        }
        View toolBarItemView3 = getToolBarItemView(9);
        if (toolBarItemView3 != null) {
            toolBarItemView3.setContentDescription(getResources().getString(R.string.obfuscated_res_0x7f0f04b7));
        }
        View toolBarItemView4 = getToolBarItemView(2);
        if (toolBarItemView4 != null) {
            toolBarItemView4.setContentDescription(getResources().getString(R.string.obfuscated_res_0x7f0f04b5));
        }
        View toolBarItemView5 = getToolBarItemView(17);
        if (toolBarItemView5 != null) {
            toolBarItemView5.setContentDescription(getResources().getString(R.string.obfuscated_res_0x7f0f04b6));
        }
        View toolBarItemView6 = getToolBarItemView(8);
        if (toolBarItemView6 != null) {
            toolBarItemView6.setContentDescription(getResources().getString(R.string.obfuscated_res_0x7f0f04b8));
        }
        View toolBarItemView7 = getToolBarItemView(18);
        if (toolBarItemView7 != null) {
            toolBarItemView7.setContentDescription(getResources().getString(R.string.obfuscated_res_0x7f0f04b4));
        }
    }

    private boolean isOnlyStarAndShareShow() {
        if (isShow(8) && isShow(9) && isShow(1) && !isShow(18) && !isShow(2) && !isShow(4) && !isShow(5) && !isShow(7) && !isShow(10) && !isShow(22) && !isShow(13)) {
            return true;
        }
        return false;
    }

    public void resetCommontInput() {
        SelectorTextView selectorTextView;
        View toolBarItemView;
        CommentInputLayout commentInputLayout = (CommentInputLayout) getToolBarItemView(10);
        if (commentInputLayout != null) {
            selectorTextView = commentInputLayout.getCommentInputView();
        } else {
            selectorTextView = null;
        }
        if (selectorTextView == null && (toolBarItemView = getToolBarItemView(22)) != null) {
            selectorTextView = (SelectorTextView) toolBarItemView.findViewById(R.id.obfuscated_res_0x7f0926fc);
        }
        if (selectorTextView != null) {
            if (TextUtils.isEmpty(this.mDefaultInput)) {
                selectorTextView.setText(getResources().getText(R.string.obfuscated_res_0x7f0f04b1));
            } else {
                selectorTextView.setText(this.mDefaultInput);
            }
            selectorTextView.setPadding(getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07025d), selectorTextView.getPaddingTop(), selectorTextView.getPaddingRight(), selectorTextView.getPaddingBottom());
        }
    }

    public void setCommonBarNormalB() {
        int dp2px = DeviceUtil.ScreenInfo.dp2px(getContext(), 4.0f);
        View toolBarItemView = getToolBarItemView(1);
        if (toolBarItemView instanceof RedTipImageView) {
            RedTipImageView redTipImageView = (RedTipImageView) toolBarItemView;
            redTipImageView.getRedTip().setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060651));
            redTipImageView.getRedTip().setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.obfuscated_res_0x7f08054e, null));
            redTipImageView.getRedTip().setTextSize(0, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07024f));
            redTipImageView.getRedTip().setPadding(dp2px, 0, dp2px, 1);
        }
    }

    public void setCommonBarPhotoB() {
        int dp2px = DeviceUtil.ScreenInfo.dp2px(getContext(), 4.0f);
        View toolBarItemView = getToolBarItemView(1);
        if (toolBarItemView instanceof RedTipImageView) {
            RedTipImageView redTipImageView = (RedTipImageView) toolBarItemView;
            redTipImageView.getRedTip().setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060651));
            redTipImageView.getRedTip().setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.obfuscated_res_0x7f08054f, null));
            redTipImageView.getRedTip().setTextSize(0, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07024f));
            redTipImageView.getRedTip().setPadding(dp2px, 0, dp2px, 1);
        }
    }

    private void setDarkUI(boolean z) {
        if (z) {
            setOnClickListener(null);
            setClickable(false);
            setBackgroundResource(R.color.transparent);
        } else {
            setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.obfuscated_res_0x7f08052e, null));
        }
        View toolBarItemView = getToolBarItemView(1);
        if (toolBarItemView instanceof RedTipImageView) {
            ((RedTipImageView) toolBarItemView).setIcon(R.drawable.obfuscated_res_0x7f080530);
        }
        View toolBarItemView2 = getToolBarItemView(7);
        if (toolBarItemView2 instanceof CommentRedTipLayout) {
            ((CommentRedTipLayout) toolBarItemView2).setCommentViewIcon(R.drawable.obfuscated_res_0x7f08053c);
        }
        updateStarViewMode();
        View toolBarItemView3 = getToolBarItemView(17);
        if (toolBarItemView3 instanceof ImageView) {
            ((ImageView) toolBarItemView3).setImageResource(R.drawable.obfuscated_res_0x7f080540);
        }
        View toolBarItemView4 = getToolBarItemView(9);
        if (toolBarItemView4 instanceof ImageView) {
            ((ImageView) toolBarItemView4).setImageResource(R.drawable.obfuscated_res_0x7f080547);
        }
        CommentInputLayout commentInputLayout = (CommentInputLayout) getToolBarItemView(10);
        if (commentInputLayout != null) {
            commentInputLayout.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.obfuscated_res_0x7f081559, null));
            SelectorTextView commentInputView = commentInputLayout.getCommentInputView();
            if (commentInputView != null) {
                commentInputView.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060650));
                commentInputView.setPadding((int) getResources().getDimension(R.dimen.obfuscated_res_0x7f07025d), 0, (int) getResources().getDimension(R.dimen.obfuscated_res_0x7f07025d), 0);
                commentInputView.setMode(true);
            }
        }
        View toolBarItemView5 = getToolBarItemView(22);
        if (toolBarItemView5 != null) {
            View findViewById = toolBarItemView5.findViewById(R.id.obfuscated_res_0x7f0926fc);
            if (findViewById instanceof SelectorTextView) {
                SelectorTextView selectorTextView = (SelectorTextView) findViewById;
                selectorTextView.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060650));
                findViewById.setBackgroundDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.obfuscated_res_0x7f081559, null));
                findViewById.setPadding((int) getResources().getDimension(R.dimen.obfuscated_res_0x7f07025d), 0, (int) getResources().getDimension(R.dimen.obfuscated_res_0x7f07025d), 0);
                selectorTextView.setMode(true);
            }
        }
        setCommonBarPhotoB();
        if (this.mIsCloseComment) {
            setCloseCommentUIForAtlas();
        }
        PraiseToolBarItem praiseToolBarItem = getPraiseToolBarItem();
        if (!this.mIsMiniVideoUISet && praiseToolBarItem != null && (praiseToolBarItem.getItemView() instanceof PraiseToolBarItemView)) {
            CoolPraiseView coolPraiseView = ((PraiseToolBarItemView) praiseToolBarItem.getItemView()).getCoolPraiseView();
            int i = AnonymousClass5.$SwitchMap$com$baidu$searchbox$toolbar$PraiseToolBarItem$PraiseIconType[praiseToolBarItem.getType().ordinal()];
            if (i != 1) {
                if (i != 2) {
                    coolPraiseView.setPraiseStateIconRes(R.drawable.obfuscated_res_0x7f080542, R.drawable.obfuscated_res_0x7f080543);
                } else {
                    praiseToolBarItem.updateCustomPraiseIcon(coolPraiseView);
                }
            } else {
                coolPraiseView.setPraiseStateIconRes(R.drawable.obfuscated_res_0x7f080518, R.drawable.obfuscated_res_0x7f080517);
            }
        }
        View toolBarItemView6 = getToolBarItemView(25);
        if (toolBarItemView6 instanceof CommentTextLayout) {
            ((CommentTextLayout) toolBarItemView6).updateColor();
        }
        View toolBarItemView7 = getToolBarItemView(26);
        if (toolBarItemView7 != null) {
            toolBarItemView7.setBackgroundColor(getResources().getColor(R.color.obfuscated_res_0x7f0601cd));
        }
    }

    private void setNormalUI(boolean z) {
        if (z) {
            setBackgroundResource(R.color.transparent);
            setOnClickListener(null);
            setClickable(false);
        } else {
            setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.obfuscated_res_0x7f08052d, null));
        }
        View toolBarItemView = getToolBarItemView(1);
        if (toolBarItemView instanceof RedTipImageView) {
            ((RedTipImageView) toolBarItemView).setIcon(R.drawable.obfuscated_res_0x7f08052f);
        }
        View toolBarItemView2 = getToolBarItemView(2);
        if (toolBarItemView2 instanceof ImageView) {
            ((ImageView) toolBarItemView2).setImageResource(R.drawable.obfuscated_res_0x7f08053d);
        }
        View toolBarItemView3 = getToolBarItemView(7);
        if (toolBarItemView3 instanceof CommentRedTipLayout) {
            ((CommentRedTipLayout) toolBarItemView3).setCommentViewIcon(R.drawable.obfuscated_res_0x7f08053a);
        }
        updateStarViewMode();
        View toolBarItemView4 = getToolBarItemView(17);
        if (toolBarItemView4 instanceof ImageView) {
            ((ImageView) toolBarItemView4).setImageResource(R.drawable.obfuscated_res_0x7f080540);
        }
        View toolBarItemView5 = getToolBarItemView(9);
        if (toolBarItemView5 instanceof ImageView) {
            ((ImageView) toolBarItemView5).setImageResource(R.drawable.obfuscated_res_0x7f080546);
        }
        CommentInputLayout commentInputLayout = (CommentInputLayout) getToolBarItemView(10);
        if (commentInputLayout != null) {
            commentInputLayout.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.obfuscated_res_0x7f08155b, null));
            SelectorTextView commentInputView = commentInputLayout.getCommentInputView();
            if (commentInputView != null) {
                commentInputView.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f06064c));
                commentInputView.setPadding((int) getResources().getDimension(R.dimen.obfuscated_res_0x7f07025d), 0, (int) getResources().getDimension(R.dimen.obfuscated_res_0x7f07025d), 0);
            }
        }
        View toolBarItemView6 = getToolBarItemView(22);
        if (toolBarItemView6 != null) {
            View findViewById = toolBarItemView6.findViewById(R.id.obfuscated_res_0x7f0926fc);
            if (findViewById instanceof TextView) {
                ((TextView) findViewById).setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f06064c));
                findViewById.setBackgroundDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.obfuscated_res_0x7f08155b, null));
                findViewById.setPadding((int) getResources().getDimension(R.dimen.obfuscated_res_0x7f07025d), 0, (int) getResources().getDimension(R.dimen.obfuscated_res_0x7f07025d), 0);
            }
        }
        View toolBarItemView7 = getToolBarItemView(21);
        if (toolBarItemView7 instanceof ImageView) {
            ((ImageView) toolBarItemView7).setImageResource(R.drawable.obfuscated_res_0x7f080538);
        }
        View toolBarItemView8 = getToolBarItemView(20);
        if (toolBarItemView8 instanceof ImageView) {
            ((ImageView) toolBarItemView8).setImageResource(R.drawable.obfuscated_res_0x7f080539);
        }
        PraiseToolBarItem praiseToolBarItem = getPraiseToolBarItem();
        if (praiseToolBarItem != null && (praiseToolBarItem.getItemView() instanceof PraiseToolBarItemView)) {
            CoolPraiseView coolPraiseView = ((PraiseToolBarItemView) praiseToolBarItem.getItemView()).getCoolPraiseView();
            int i = AnonymousClass5.$SwitchMap$com$baidu$searchbox$toolbar$PraiseToolBarItem$PraiseIconType[praiseToolBarItem.getType().ordinal()];
            if (i != 1) {
                if (i != 2) {
                    coolPraiseView.setPraiseStateIconRes(R.drawable.obfuscated_res_0x7f080541, R.drawable.obfuscated_res_0x7f080543);
                } else {
                    praiseToolBarItem.updateCustomPraiseIcon(coolPraiseView);
                }
            } else {
                coolPraiseView.setPraiseStateIconRes(R.drawable.obfuscated_res_0x7f080518, R.drawable.obfuscated_res_0x7f080517);
            }
        }
        View toolBarItemView9 = getToolBarItemView(15);
        if (toolBarItemView9 instanceof ImageView) {
            ((ImageView) toolBarItemView9).setImageResource(R.drawable.obfuscated_res_0x7f08054b);
        }
        View toolBarItemView10 = getToolBarItemView(18);
        if (toolBarItemView10 instanceof ImageView) {
            ((ImageView) toolBarItemView10).setImageResource(R.drawable.obfuscated_res_0x7f080533);
        }
        setCommonBarNormalB();
        updateWendaUI();
        if (this.mIsCloseComment) {
            setCloseCommentUIForNews();
        }
        View toolBarItemView11 = getToolBarItemView(23);
        if (toolBarItemView11 instanceof ImageView) {
            if (this.mIsRecommended) {
                ((ImageView) toolBarItemView11).setImageResource(R.drawable.obfuscated_res_0x7f080545);
            } else {
                ((ImageView) toolBarItemView11).setImageResource(R.drawable.obfuscated_res_0x7f080544);
            }
        }
        View toolBarItemView12 = getToolBarItemView(25);
        if (toolBarItemView12 instanceof CommentTextLayout) {
            ((CommentTextLayout) toolBarItemView12).updateColor();
        }
        View toolBarItemView13 = getToolBarItemView(26);
        if (toolBarItemView13 != null) {
            toolBarItemView13.setBackgroundColor(getResources().getColor(R.color.obfuscated_res_0x7f0601cd));
        }
    }

    private void updateCommonToolBarView() {
        View toolBarItemView = getToolBarItemView(10);
        if (toolBarItemView != null) {
            if (toolBarItemView.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) toolBarItemView.getLayoutParams();
                if (!isShow(7) && !isShow(8)) {
                    if (isShow(9)) {
                        layoutParams.rightMargin = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07025f);
                        toolBarItemView.setLayoutParams(layoutParams);
                    }
                } else if (!isShow(7) && !isShow(9)) {
                    if (isShow(8)) {
                        layoutParams.rightMargin = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07025f);
                    }
                } else if (this.mIsMiniVideoVerticalLandingStyle) {
                    layoutParams.rightMargin = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07025c);
                } else {
                    layoutParams.rightMargin = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07025e);
                }
                toolBarItemView.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        View toolBarItemView2 = getToolBarItemView(22);
        if (toolBarItemView2 != null && (toolBarItemView2.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) toolBarItemView2.getLayoutParams();
            if (!isShow(7) && !isShow(8)) {
                if (isShow(9)) {
                    layoutParams2.rightMargin = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07025f);
                }
            } else if (!isShow(7) && !isShow(9)) {
                if (isShow(8)) {
                    layoutParams2.rightMargin = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07025f);
                }
            } else if (this.mIsMiniVideoVerticalLandingStyle) {
                layoutParams2.rightMargin = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07025c);
            } else {
                layoutParams2.rightMargin = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07025e);
            }
            toolBarItemView2.setLayoutParams(layoutParams2);
        }
    }

    public void addVoiceEnter(View view2) {
        View toolBarItemView = getToolBarItemView(4);
        if (toolBarItemView instanceof ViewGroup) {
            ((ViewGroup) toolBarItemView).addView(view2, new LinearLayout.LayoutParams(-1, -1));
        }
    }

    public void enableSoFa(boolean z) {
        this.mEnableSoFa = z;
    }

    public void endCommentInputGuide(boolean z) {
        CommentInputLayout commentInputLayout = (CommentInputLayout) getToolBarItemView(10);
        if (commentInputLayout != null) {
            commentInputLayout.endCommentInputGuide(z);
        }
    }

    public boolean isShow(int i) {
        View toolBarItemView = getToolBarItemView(i);
        if (toolBarItemView != null && toolBarItemView.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    public void setClickPraiseListener(CoolPraiseView.OnClickPraiseListener onClickPraiseListener) {
        View toolBarItemView = getToolBarItemView(13);
        if ((toolBarItemView instanceof PraiseToolBarItemView) && onClickPraiseListener != null) {
            ((PraiseToolBarItemView) toolBarItemView).getCoolPraiseView().setOnClickPraiseListener(onClickPraiseListener);
        }
    }

    public void setCloseComment(boolean z) {
        this.mIsCloseComment = z;
    }

    public CommonToolBar setCommentsStatus(String str) {
        ToolBarNewType toolBarNewType;
        if (str == null) {
            toolBarNewType = ToolBarNewType.NO_TIP;
        } else if (TextUtils.isEmpty(str.trim())) {
            toolBarNewType = ToolBarNewType.DOT_TIP;
        } else {
            toolBarNewType = ToolBarNewType.STRING_TIP;
        }
        View toolBarItemView = getToolBarItemView(7);
        if (toolBarItemView instanceof CommentRedTipLayout) {
            CommentRedTipLayout commentRedTipLayout = (CommentRedTipLayout) toolBarItemView;
            if (toolBarNewType != ToolBarNewType.STRING_TIP) {
                str = "";
            }
            commentRedTipLayout.setCommentsStatus(this, toolBarNewType, str);
        }
        return this;
    }

    public CommonToolBar setDefaultInput(String str) {
        this.mDefaultInput = str;
        return this;
    }

    public void setIncognito(boolean z) {
        this.isIncognito = z;
    }

    public void setMiniVideoRightInteraction(boolean z) {
        this.mIsMiniVideoRightInteraction = z;
    }

    public void setMiniVideoVerticalLandingStyle(boolean z) {
        this.mIsMiniVideoVerticalLandingStyle = z;
    }

    public void setOnShareViewLayoutChangeListener(View.OnLayoutChangeListener onLayoutChangeListener) {
        View toolBarItemView = getToolBarItemView(9);
        if (onLayoutChangeListener != null && toolBarItemView != null) {
            toolBarItemView.addOnLayoutChangeListener(onLayoutChangeListener);
        }
    }

    public CommonToolBar setPraiseCounts(int i) {
        View toolBarItemView = getToolBarItemView(13);
        if (toolBarItemView instanceof PraiseToolBarItemView) {
            ((PraiseToolBarItemView) toolBarItemView).getCoolPraiseView().setPraiseCount(i);
        }
        return this;
    }

    public void setPraiseId(String str) {
        View toolBarItemView = getToolBarItemView(13);
        if (toolBarItemView instanceof PraiseToolBarItemView) {
            ((PraiseToolBarItemView) toolBarItemView).getCoolPraiseView().setPraiseId(str);
        }
    }

    public CommonToolBar setPraiseStatus(String str) {
        ToolBarNewType toolBarNewType;
        if (str == null) {
            toolBarNewType = ToolBarNewType.NO_TIP;
        } else if (str.trim() != "" && !"0".equals(str)) {
            toolBarNewType = ToolBarNewType.STRING_TIP;
        } else {
            toolBarNewType = ToolBarNewType.DOT_TIP;
        }
        if (toolBarNewType != ToolBarNewType.STRING_TIP) {
            str = "";
        }
        setPraiseStatus(toolBarNewType, str);
        return this;
    }

    public void setRecommendViewState(boolean z) {
        ImageView imageView;
        View toolBarItemView = getToolBarItemView(23);
        if (toolBarItemView instanceof ImageView) {
            imageView = (ImageView) toolBarItemView;
        } else {
            imageView = null;
        }
        if (imageView == null) {
            return;
        }
        this.mIsRecommended = z;
        if (z) {
            imageView.setImageResource(R.drawable.obfuscated_res_0x7f080545);
        } else {
            imageView.setImageResource(R.drawable.obfuscated_res_0x7f080544);
        }
    }

    public void setSoFa(boolean z) {
        this.mIsSoFa = z;
    }

    public CommonToolBar setStarEnable(boolean z) {
        RedTipImageView redTipImageView = (RedTipImageView) getToolBarItemView(8);
        if (redTipImageView != null) {
            redTipImageView.setEnabled(z);
            redTipImageView.setClickable(z);
        }
        return this;
    }

    public CommonToolBar setStarStatus(boolean z) {
        RedTipImageView redTipImageView = (RedTipImageView) getToolBarItemView(8);
        if (redTipImageView != null) {
            redTipImageView.setTag(Boolean.valueOf(z));
            ToolbarMode toolbarMode = this.mMode;
            ToolbarMode toolbarMode2 = ToolbarMode.DARK;
            int i = R.drawable.obfuscated_res_0x7f08054a;
            if (toolbarMode == toolbarMode2) {
                if (!z) {
                    i = R.drawable.obfuscated_res_0x7f080549;
                }
                redTipImageView.setIcon(i);
            } else {
                if (!z) {
                    i = R.drawable.obfuscated_res_0x7f080548;
                }
                redTipImageView.setIcon(i);
            }
        }
        return this;
    }

    public void setStatisticSource(String str) {
        this.mStatisticSource = str;
    }

    public void setToolBarBackState(int i) {
        View toolBarItemView = getToolBarItemView(1);
        if (toolBarItemView != null) {
            toolBarItemView.setVisibility(i);
        }
    }

    public void startStarAnim(boolean z) {
        RedTipImageView redTipImageView = (RedTipImageView) getToolBarItemView(8);
        if (redTipImageView != null) {
            redTipImageView.setIconAlpha(0.0f);
            redTipImageView.startStarAnim(z);
        }
    }

    public void updateUI(boolean z) {
        if (this.mMode == ToolbarMode.DARK) {
            setDarkUI(z);
        } else {
            setNormalUI(z);
        }
    }

    @Override // com.baidu.searchbox.toolbar.BaseToolBar
    @NonNull
    public View createToolBarItemView(int i) {
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070262);
        int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070263);
        switch (i) {
            case 1:
                RedTipImageView redTipImageView = new RedTipImageView(getContext());
                redTipImageView.setIsIgnoreFontSizeParams(false);
                redTipImageView.setIsResponseFontSize(getIsResponseFontSize(1));
                redTipImageView.setIcon(R.drawable.obfuscated_res_0x7f08052f);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelOffset2, dimensionPixelOffset2);
                layoutParams.leftMargin = getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070264);
                redTipImageView.setLayoutParams(layoutParams);
                return redTipImageView;
            case 2:
                SelectorImageView selectorImageView = new SelectorImageView(getContext());
                selectorImageView.setIsResponseFontSize(getIsResponseFontSize(2));
                selectorImageView.setImageResource(R.drawable.obfuscated_res_0x7f08053d);
                selectorImageView.setScaleType(ImageView.ScaleType.CENTER);
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(dimensionPixelOffset2, dimensionPixelOffset2);
                layoutParams2.rightMargin = getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070264);
                selectorImageView.setScaledDrawableLayoutParams(layoutParams2);
                return selectorImageView;
            case 3:
            case 4:
            case 5:
            case 6:
            case 11:
            case 12:
            case 16:
            case 19:
            case 24:
            default:
                return super.createToolBarItemView(i);
            case 7:
                CommentRedTipLayout commentRedTipLayout = new CommentRedTipLayout(getContext());
                commentRedTipLayout.setIsResponseFontSize(getIsResponseFontSize(7));
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dimensionPixelOffset2, -1);
                layoutParams3.leftMargin = dimensionPixelOffset;
                layoutParams3.rightMargin = dimensionPixelOffset;
                layoutParams3.weight = dimensionPixelOffset2;
                layoutParams3.height = dimensionPixelOffset2;
                commentRedTipLayout.setCommentViewLayoutParams(layoutParams3);
                return commentRedTipLayout;
            case 8:
                RedTipImageView redTipImageView2 = new RedTipImageView(getContext());
                redTipImageView2.setIsResponseFontSize(getIsResponseFontSize(8));
                redTipImageView2.setIcon(R.drawable.obfuscated_res_0x7f080548);
                LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(dimensionPixelOffset2, dimensionPixelOffset2);
                layoutParams4.leftMargin = dimensionPixelOffset;
                layoutParams4.rightMargin = dimensionPixelOffset;
                redTipImageView2.setLayoutParams(layoutParams4);
                return redTipImageView2;
            case 9:
                SelectorImageView selectorImageView2 = new SelectorImageView(getContext());
                selectorImageView2.setIsResponseFontSize(getIsResponseFontSize(9));
                selectorImageView2.setImageResource(R.drawable.obfuscated_res_0x7f080546);
                selectorImageView2.setScaleType(ImageView.ScaleType.CENTER);
                LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(dimensionPixelOffset2, dimensionPixelOffset2);
                layoutParams5.rightMargin = getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070264);
                selectorImageView2.setScaledDrawableLayoutParams(layoutParams5);
                return selectorImageView2;
            case 10:
                CommentInputLayout commentInputLayout = new CommentInputLayout(getContext());
                LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070259));
                layoutParams6.weight = 1.0f;
                layoutParams6.leftMargin = getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f07025b);
                layoutParams6.rightMargin = getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f07025e);
                commentInputLayout.setLayoutParams(layoutParams6);
                commentInputLayout.setIsResponseFontSize(getIsResponseFontSize(10));
                return commentInputLayout;
            case 13:
                PraiseToolBarItemView praiseToolBarItemView = new PraiseToolBarItemView(getContext());
                praiseToolBarItemView.setIsResponseFontSize(getIsResponseFontSize(13));
                praiseToolBarItemView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                praiseToolBarItemView.setIsMiniVideoVerticalLandingStyle(this.mIsMiniVideoVerticalLandingStyle);
                return praiseToolBarItemView;
            case 14:
                WendaToolBarItemView wendaToolBarItemView = new WendaToolBarItemView(getContext());
                wendaToolBarItemView.setIsResponseFontSize(getIsResponseFontSize(14));
                wendaToolBarItemView.setVisibility(8);
                wendaToolBarItemView.setLayoutParams(new LinearLayout.LayoutParams(getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f07026d), dimensionPixelOffset2));
                return wendaToolBarItemView;
            case 15:
                BdBaseImageView bdBaseImageView = new BdBaseImageView(getContext());
                bdBaseImageView.setIsResponseFontSize(getIsResponseFontSize(15));
                bdBaseImageView.setScaleType(ImageView.ScaleType.CENTER);
                bdBaseImageView.setImageResource(R.drawable.obfuscated_res_0x7f08054b);
                bdBaseImageView.setVisibility(8);
                LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(dimensionPixelOffset2, dimensionPixelOffset2);
                layoutParams7.leftMargin = dimensionPixelOffset;
                layoutParams7.rightMargin = dimensionPixelOffset;
                bdBaseImageView.setScaledDrawableLayoutParams(layoutParams7);
                return bdBaseImageView;
            case 17:
                SelectorImageView selectorImageView3 = new SelectorImageView(getContext());
                selectorImageView3.setIsResponseFontSize(getIsResponseFontSize(17));
                selectorImageView3.setScaleType(ImageView.ScaleType.CENTER);
                selectorImageView3.setImageResource(R.drawable.obfuscated_res_0x7f080540);
                LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(dimensionPixelOffset2, dimensionPixelOffset2);
                layoutParams8.leftMargin = dimensionPixelOffset;
                layoutParams8.rightMargin = dimensionPixelOffset;
                selectorImageView3.setScaledDrawableLayoutParams(layoutParams8);
                return selectorImageView3;
            case 18:
                BdBaseImageView bdBaseImageView2 = new BdBaseImageView(getContext());
                bdBaseImageView2.setScaleType(ImageView.ScaleType.CENTER);
                bdBaseImageView2.setImageResource(R.drawable.obfuscated_res_0x7f08052f);
                bdBaseImageView2.setVisibility(8);
                LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(dimensionPixelOffset2, dimensionPixelOffset2);
                layoutParams9.leftMargin = dimensionPixelOffset;
                bdBaseImageView2.setScaledDrawableLayoutParams(layoutParams9);
                return bdBaseImageView2;
            case 20:
                SelectorImageView selectorImageView4 = new SelectorImageView(getContext());
                selectorImageView4.setIsResponseFontSize(getIsResponseFontSize(20));
                selectorImageView4.setImageResource(R.drawable.obfuscated_res_0x7f080539);
                selectorImageView4.setScaleType(ImageView.ScaleType.CENTER);
                LinearLayout.LayoutParams layoutParams10 = new LinearLayout.LayoutParams(dimensionPixelOffset2, dimensionPixelOffset2);
                layoutParams10.rightMargin = getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070264);
                selectorImageView4.setScaledDrawableLayoutParams(layoutParams10);
                return selectorImageView4;
            case 21:
                SelectorImageView selectorImageView5 = new SelectorImageView(getContext());
                selectorImageView5.setIsResponseFontSize(getIsResponseFontSize(21));
                selectorImageView5.setImageResource(R.drawable.obfuscated_res_0x7f080538);
                selectorImageView5.setScaleType(ImageView.ScaleType.CENTER);
                LinearLayout.LayoutParams layoutParams11 = new LinearLayout.LayoutParams(dimensionPixelOffset2, dimensionPixelOffset2);
                layoutParams11.leftMargin = dimensionPixelOffset;
                layoutParams11.rightMargin = dimensionPixelOffset;
                selectorImageView5.setScaledDrawableLayoutParams(layoutParams11);
                return selectorImageView5;
            case 22:
                FrameLayout frameLayout = new FrameLayout(getContext());
                LinearLayout.LayoutParams layoutParams12 = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070259));
                layoutParams12.weight = 1.0f;
                layoutParams12.leftMargin = getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f07025b);
                layoutParams12.rightMargin = getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f07025e);
                frameLayout.setLayoutParams(layoutParams12);
                SelectorTextView selectorTextView = new SelectorTextView(getContext());
                selectorTextView.setId(R.id.obfuscated_res_0x7f0926fc);
                selectorTextView.setPadding(getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f07025d), 0, 0, 0);
                selectorTextView.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07025a));
                selectorTextView.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.obfuscated_res_0x7f08155b, null));
                selectorTextView.setText(R.string.obfuscated_res_0x7f0f04b1);
                selectorTextView.setSingleLine(true);
                selectorTextView.setEllipsize(TextUtils.TruncateAt.END);
                selectorTextView.setGravity(16);
                frameLayout.addView(selectorTextView, new FrameLayout.LayoutParams(-1, -1));
                SelectorImageView selectorImageView6 = new SelectorImageView(getContext());
                selectorImageView6.setId(R.id.obfuscated_res_0x7f0926fd);
                selectorImageView6.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.obfuscated_res_0x7f081557, null));
                selectorImageView6.setScaleType(ImageView.ScaleType.CENTER);
                int dimensionPixelOffset3 = getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070259);
                int dimensionPixelOffset4 = getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070b4c);
                selectorImageView6.setPadding(dimensionPixelOffset4, dimensionPixelOffset4, dimensionPixelOffset4, dimensionPixelOffset4);
                selectorImageView6.setVisibility(8);
                FrameLayout.LayoutParams layoutParams13 = new FrameLayout.LayoutParams(dimensionPixelOffset3, dimensionPixelOffset3);
                layoutParams13.gravity = 21;
                frameLayout.addView(selectorImageView6, layoutParams13);
                return frameLayout;
            case 23:
                FontSizeImageView fontSizeImageView = new FontSizeImageView(getContext());
                fontSizeImageView.setIsResponseFontSize(getIsResponseFontSize(23));
                fontSizeImageView.setScaleType(ImageView.ScaleType.CENTER);
                fontSizeImageView.setImageResource(R.drawable.obfuscated_res_0x7f080544);
                fontSizeImageView.setVisibility(8);
                LinearLayout.LayoutParams layoutParams14 = new LinearLayout.LayoutParams(dimensionPixelOffset2, dimensionPixelOffset2);
                layoutParams14.leftMargin = dimensionPixelOffset;
                layoutParams14.rightMargin = dimensionPixelOffset;
                fontSizeImageView.setScaledDrawableLayoutParams(layoutParams14);
                return fontSizeImageView;
            case 25:
                CommentTextLayout commentTextLayout = new CommentTextLayout(getContext());
                commentTextLayout.setIsResponseFontSize(getIsResponseFontSize(25));
                RelativeLayout.LayoutParams layoutParams15 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams15.leftMargin = dimensionPixelOffset;
                layoutParams15.rightMargin = dimensionPixelOffset;
                commentTextLayout.setLayoutParams(layoutParams15);
                return commentTextLayout;
            case 26:
                View view2 = new View(getContext());
                view2.setBackgroundColor(getResources().getColor(R.color.obfuscated_res_0x7f0601cd));
                LinearLayout.LayoutParams layoutParams16 = new LinearLayout.LayoutParams(getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f07026c), getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070269));
                int dimensionPixelOffset5 = getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f07026b);
                layoutParams16.leftMargin = dimensionPixelOffset5;
                layoutParams16.rightMargin = dimensionPixelOffset5;
                view2.setLayoutParams(layoutParams16);
                return view2;
        }
    }

    public CommonToolBar setBackStatus(String str) {
        View toolBarItemView = getToolBarItemView(1);
        if (toolBarItemView instanceof RedTipImageView) {
            if (!TextUtils.isEmpty(str) && !"0".equals(str)) {
                RedTipImageView redTipImageView = (RedTipImageView) toolBarItemView;
                redTipImageView.setNewTip(ToolBarNewType.STRING_TIP, str);
                redTipImageView.getRedTip().setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.obfuscated_res_0x7f08054e, null));
                toolBarItemView.setTag(str);
            } else {
                ((RedTipImageView) toolBarItemView).setNewTip(null, "");
            }
        }
        return this;
    }

    public CommonToolBar setPraiseStatus(CommonToolBarLikeInfo commonToolBarLikeInfo) {
        PraiseToolBarItem praiseToolBarItem = (PraiseToolBarItem) getToolBarItem(13);
        if (commonToolBarLikeInfo != null && praiseToolBarItem != null && praiseToolBarItem.getItemView() != null) {
            CoolPraiseView coolPraiseView = ((PraiseToolBarItemView) praiseToolBarItem.getItemView()).getCoolPraiseView();
            coolPraiseView.setPraiseSource(PraiseSourceDef.NA_PRAISE_SRC_DYNAMIC_IMGTXT_DETAIL_BAR).setUBC(PraiseUBCHelper.SOURCE_DYNAMIC_IMGTXT);
            coolPraiseView.setPraiseId(commonToolBarLikeInfo.nid);
            praiseToolBarItem.setLikeInfo(commonToolBarLikeInfo);
            setPraiseStatus(commonToolBarLikeInfo.isLiked);
            setPraiseCounts(commonToolBarLikeInfo.likeCount);
            return this;
        }
        return null;
    }

    public CommonToolBar setCommentInput(SpannableString spannableString) {
        SelectorTextView selectorTextView;
        View toolBarItemView;
        CommentInputLayout commentInputLayout = (CommentInputLayout) getToolBarItemView(10);
        if (commentInputLayout != null) {
            selectorTextView = commentInputLayout.getCommentInputView();
            commentInputLayout.releaseAnim();
        } else {
            selectorTextView = null;
        }
        if (selectorTextView == null && (toolBarItemView = getToolBarItemView(22)) != null) {
            selectorTextView = (SelectorTextView) toolBarItemView.findViewById(R.id.obfuscated_res_0x7f0926fc);
        }
        if (selectorTextView != null) {
            if (spannableString != null && spannableString.length() != 0 && !this.mIsCloseComment) {
                String string = getResources().getString(R.string.obfuscated_res_0x7f0f04ba);
                if (TextUtils.isEmpty(string)) {
                    return this;
                }
                if (!TextUtils.isEmpty(selectorTextView.getText().toString()) && selectorTextView.getText().toString().contains(string) && !spannableString.toString().contains(string)) {
                    return this;
                }
                selectorTextView.setText(EmotionLoader.getInstance().parseEmotion(EmotionType.EMOTION_CLASSIC_TYPE, getContext(), spannableString, selectorTextView, 1.2f), TextView.BufferType.SPANNABLE);
            } else {
                resetCommontInput();
            }
        }
        return this;
    }

    public void setCommentInputGuide(SpannableString spannableString, boolean z) {
        CommentInputLayout commentInputLayout = (CommentInputLayout) getToolBarItemView(10);
        if (commentInputLayout != null) {
            commentInputLayout.startCommentInputGuide(spannableString, z);
        }
    }

    public CommonToolBar setPraiseStatus(ToolBarNewType toolBarNewType, String str) {
        View toolBarItemView = getToolBarItemView(13);
        if (toolBarItemView instanceof PraiseToolBarItemView) {
            ((PraiseToolBarItemView) toolBarItemView).setPraiseStatus(toolBarNewType, str);
        }
        return this;
    }

    public void setToolBarItemAlpha(int i, float f) {
        View toolBarItemView = getToolBarItemView(i);
        if (toolBarItemView != null) {
            toolBarItemView.setAlpha(f);
        }
    }

    public void setVisible(int i, boolean z) {
        View toolBarItemView = getToolBarItemView(i);
        if (toolBarItemView == null) {
            return;
        }
        int i2 = 0;
        if (i != 10 && i != 22) {
            if (!z) {
                i2 = 8;
            }
            toolBarItemView.setVisibility(i2);
        } else {
            if (!z) {
                i2 = 4;
            }
            toolBarItemView.setVisibility(i2);
        }
        updateCommonToolBarView();
    }

    public void setMiniVideoUI() {
        SelectorTextView selectorTextView;
        this.mIsMiniVideoUISet = true;
        setBackgroundColor(0);
        View toolBarItemView = getToolBarItemView(1);
        CommentInputLayout commentInputLayout = (CommentInputLayout) getToolBarItemView(10);
        if (commentInputLayout != null) {
            commentInputLayout.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.obfuscated_res_0x7f08155a, null));
            selectorTextView = commentInputLayout.getCommentInputView();
        } else {
            selectorTextView = null;
        }
        if (this.mIsMiniVideoRightInteraction) {
            if (toolBarItemView instanceof RedTipImageView) {
                ((RedTipImageView) toolBarItemView).setIcon(R.drawable.obfuscated_res_0x7f080530);
            }
            if (selectorTextView != null) {
                selectorTextView.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f06064f));
                selectorTextView.setPadding((int) getResources().getDimension(R.dimen.obfuscated_res_0x7f07025d), 0, (int) getResources().getDimension(R.dimen.obfuscated_res_0x7f07025d), 0);
                selectorTextView.setMode(true);
                selectorTextView.setText(getResources().getText(R.string.obfuscated_res_0x7f0f04b1));
            }
            if (this.mIsCloseComment) {
                setCloseCommentUIForMiniVideo();
                return;
            }
            return;
        }
        boolean z = toolBarItemView instanceof RedTipImageView;
        if (z) {
            ((RedTipImageView) toolBarItemView).setIcon(R.drawable.obfuscated_res_0x7f080530);
        }
        View toolBarItemView2 = getToolBarItemView(7);
        if (toolBarItemView2 instanceof CommentRedTipLayout) {
            ((CommentRedTipLayout) toolBarItemView2).setCommentViewIcon(R.drawable.obfuscated_res_0x7f08053c);
        }
        View toolBarItemView3 = getToolBarItemView(9);
        if (toolBarItemView3 instanceof ImageView) {
            ((ImageView) toolBarItemView3).setImageResource(R.drawable.obfuscated_res_0x7f080547);
        }
        View toolBarItemView4 = getToolBarItemView(13);
        if (toolBarItemView4 == null) {
            return;
        }
        if (toolBarItemView4 instanceof PraiseToolBarItemView) {
            PraiseToolBarItemView praiseToolBarItemView = (PraiseToolBarItemView) toolBarItemView4;
            praiseToolBarItemView.getCoolPraiseView().setPraiseSource(PraiseSourceDef.NA_PRAISE_SRC_MINI_VIDEO_DETAIL_BAR).setUBC(PraiseUBCHelper.SOURCE_MINIVIDEO);
            praiseToolBarItemView.getCoolPraiseView().setPraiseStateIconRes(R.drawable.obfuscated_res_0x7f080542, R.drawable.obfuscated_res_0x7f080543);
            praiseToolBarItemView.updateToMiniVideoUI(toolBarItemView3);
        }
        if (selectorTextView instanceof SelectorTextView) {
            selectorTextView.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f06064f));
            selectorTextView.setPadding((int) getResources().getDimension(R.dimen.obfuscated_res_0x7f07025d), 0, (int) getResources().getDimension(R.dimen.obfuscated_res_0x7f07025d), 0);
            selectorTextView.setMode(true);
        }
        int dp2px = DeviceUtil.ScreenInfo.dp2px(getContext(), 4.0f);
        if (z) {
            RedTipImageView redTipImageView = (RedTipImageView) toolBarItemView;
            redTipImageView.getRedTip().setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060651));
            redTipImageView.getRedTip().setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.obfuscated_res_0x7f08054d, null));
            redTipImageView.getRedTip().setTextSize(0, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07024f));
            redTipImageView.getRedTip().setPadding(dp2px, 0, dp2px, 1);
        }
        if (this.mIsCloseComment) {
            setCloseCommentUIForMiniVideo();
        }
    }

    public CommonToolBar setPraiseCounts(String str) {
        View toolBarItemView = getToolBarItemView(13);
        if (toolBarItemView instanceof PraiseToolBarItemView) {
            ((PraiseToolBarItemView) toolBarItemView).getCoolPraiseView().setPraiseCount(str);
        }
        return this;
    }

    public CommonToolBar setPraiseStatus(boolean z) {
        View toolBarItemView = getToolBarItemView(13);
        if (toolBarItemView instanceof PraiseToolBarItemView) {
            ((PraiseToolBarItemView) toolBarItemView).setPraise(z);
        }
        return this;
    }

    public void setWendaBar(int i, String str, String str2, JSONObject jSONObject) {
        BaseToolBarItem toolBarItem;
        if (!isOnlyStarAndShareShow() || (toolBarItem = getToolBarItem(14)) == null) {
            return;
        }
        if (toolBarItem instanceof WendaToolBarItem) {
            WendaToolBarItem wendaToolBarItem = (WendaToolBarItem) toolBarItem;
            wendaToolBarItem.setExtObj(jSONObject);
            wendaToolBarItem.setJumpScheme(str2);
            wendaToolBarItem.setStatus(i);
        }
        if (toolBarItem.getItemView() instanceof WendaToolBarItemView) {
            toolBarItem.getItemView().setVisibility(0);
            ((WendaToolBarItemView) toolBarItem.getItemView()).getWendaBarTitleTv().setText(str);
            ((WendaToolBarItemView) toolBarItem.getItemView()).setWendaBarStatus(i);
            ((WendaToolBarItemView) toolBarItem.getItemView()).updateWendaUI();
        }
    }
}
