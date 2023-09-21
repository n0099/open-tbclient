package com.baidu.searchbox.toolbar;

import android.text.TextUtils;
import com.baidu.searchbox.ui.CoolPraiseView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class PraiseToolBarItem extends BaseToolBarItem {
    public static final boolean COMMENT_PRAISE_ICON_DEFALUT = false;
    public static final String COMMENT_PRAISE_ICON_SWITCH = "comment_praise_icon";
    public static final String FORBID_ANIMATION = "1";
    public String mDisableAnim;
    public String mIconName;
    public CommonToolBarLikeInfo mLikeInfo;
    public PraiseIconType mType;

    /* loaded from: classes4.dex */
    public enum PraiseIconType {
        DEFAULT,
        HEARTS,
        CUSTOM
    }

    public boolean getPraiseIconSwitcher() {
        return false;
    }

    /* renamed from: com.baidu.searchbox.toolbar.PraiseToolBarItem$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$searchbox$toolbar$PraiseToolBarItem$PraiseIconType;

        static {
            int[] iArr = new int[PraiseIconType.values().length];
            $SwitchMap$com$baidu$searchbox$toolbar$PraiseToolBarItem$PraiseIconType = iArr;
            try {
                iArr[PraiseIconType.HEARTS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$toolbar$PraiseToolBarItem$PraiseIconType[PraiseIconType.CUSTOM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public PraiseToolBarItem(int i) {
        super(i);
        this.mType = PraiseIconType.DEFAULT;
    }

    public void setLikeInfo(CommonToolBarLikeInfo commonToolBarLikeInfo) {
        this.mLikeInfo = commonToolBarLikeInfo;
    }

    public void setPraiseIconSwitcher(boolean z) {
        PraiseIconType praiseIconType;
        if (z) {
            praiseIconType = PraiseIconType.HEARTS;
        } else {
            praiseIconType = PraiseIconType.DEFAULT;
        }
        this.mType = praiseIconType;
    }

    public void setType(PraiseIconType praiseIconType) {
        this.mType = praiseIconType;
    }

    public void updatePraiseRes(CoolPraiseView coolPraiseView) {
        int i = AnonymousClass1.$SwitchMap$com$baidu$searchbox$toolbar$PraiseToolBarItem$PraiseIconType[this.mType.ordinal()];
        if (i != 1) {
            if (i != 2) {
                coolPraiseView.setPraiseStateIconRes(R.drawable.obfuscated_res_0x7f080537, R.drawable.obfuscated_res_0x7f080539);
                return;
            } else {
                updateCustomPraiseIcon(coolPraiseView);
                return;
            }
        }
        coolPraiseView.setPraiseStateIconRes(R.drawable.obfuscated_res_0x7f08050e, R.drawable.obfuscated_res_0x7f08050d);
    }

    public PraiseToolBarItem(int i, boolean z, boolean z2) {
        super(i, z);
        PraiseIconType praiseIconType = PraiseIconType.DEFAULT;
        this.mType = praiseIconType;
        this.mType = z2 ? PraiseIconType.HEARTS : praiseIconType;
    }

    public CommonToolBarLikeInfo getLikeInfo() {
        return this.mLikeInfo;
    }

    public PraiseIconType getType() {
        return this.mType;
    }

    public void setCustomIconInfo(String str, String str2) {
        this.mIconName = str;
        this.mDisableAnim = str2;
    }

    public void updateCustomPraiseIcon(CoolPraiseView coolPraiseView) {
        if (this.mType == PraiseIconType.CUSTOM && coolPraiseView != null) {
            if (!TextUtils.isEmpty(this.mIconName) && !TextUtils.isEmpty(this.mDisableAnim)) {
                coolPraiseView.setPraiseIconResByName(this.mIconName, TextUtils.equals(this.mDisableAnim, "1"), R.drawable.obfuscated_res_0x7f080537, R.drawable.obfuscated_res_0x7f080539);
                return;
            }
            coolPraiseView.setPraiseStateIconRes(R.drawable.obfuscated_res_0x7f080537, R.drawable.obfuscated_res_0x7f080539);
            this.mType = PraiseIconType.DEFAULT;
        }
    }
}
