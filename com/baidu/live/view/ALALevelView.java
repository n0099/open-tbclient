package com.baidu.live.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.data.AlaLiveMarkData;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.af;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.widget.TbImageView;
import java.util.List;
/* loaded from: classes4.dex */
public class ALALevelView extends LinearLayout {
    private int bmP;
    private int bmQ;
    private FrameLayout bmR;
    private ImageView bmS;
    private TextView bmT;
    private TextView bmU;
    private TbImageView bmV;
    private TbImageView bmW;
    private TextView bmX;
    private ImageView bmY;
    private int bmZ;
    private int bna;
    private AlaLiveMarkData bnb;

    public ALALevelView(Context context) {
        super(context);
        this.bmP = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds38);
        this.bmQ = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds7);
        init(context);
    }

    public ALALevelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bmP = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds38);
        this.bmQ = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds7);
        init(context);
    }

    public ALALevelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bmP = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds38);
        this.bmQ = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds7);
        init(context);
    }

    private void init(Context context) {
        setGravity(16);
        setOrientation(0);
    }

    public void setData(af afVar) {
        if (afVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.bmZ = 0;
        this.bna = 0;
        T(afVar.live_mark_info_new);
        removeAllViews();
        if (TextUtils.isEmpty(afVar.third_app_id)) {
            setupLevelIcon(afVar.level_id);
            setupOfficialIcon(afVar.is_official == 1);
            KD();
            return;
        }
        KE();
    }

    public void setData(com.baidu.live.data.a aVar) {
        if (aVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        removeAllViews();
        this.bmZ = 0;
        this.bna = 0;
        T(aVar.axQ);
        if (TextUtils.isEmpty(aVar.appId)) {
            setupLevelIcon(aVar.level_id);
            setupOfficialIcon(aVar.axN);
            KD();
            E(aVar.tagName, aVar.axP);
            return;
        }
        KE();
    }

    public void setData(AlaLiveUserInfoData alaLiveUserInfoData) {
        if (alaLiveUserInfoData == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.bmZ = 0;
        this.bna = 0;
        T(alaLiveUserInfoData.live_mark_info_new);
        removeAllViews();
        setupLevelIconImage(alaLiveUserInfoData.levelId);
        setupClubIcon(alaLiveUserInfoData.clubMemberLevel);
        KD();
    }

    public void T(List<AlaLiveMarkData> list) {
        int i;
        if (list == null) {
            this.bnb = null;
            return;
        }
        int i2 = 0;
        while (true) {
            i = i2;
            if (i >= list.size()) {
                break;
            }
            AlaLiveMarkData alaLiveMarkData = list.get(i);
            if (alaLiveMarkData.type != 2) {
                i2 = i + 1;
            } else {
                this.bnb = alaLiveMarkData;
                break;
            }
        }
        if (i >= list.size()) {
            this.bnb = null;
        }
    }

    public void setupLevelIcon(int i) {
        if (this.bmT == null) {
            this.bmT = new TextView(getContext());
            this.bmT.setTextSize(0, getResources().getDimensionPixelSize(a.e.sdk_tbfontsize22));
            this.bmT.setGravity(49);
            this.bmT.setPadding(0, getResources().getDimensionPixelSize(a.e.sdk_tbds4), 0, 0);
            this.bmT.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
        }
        if (this.bmT.getParent() == null) {
            addView(this.bmT, 0);
        }
        this.bmT.setText(i + "");
        this.bmT.getPaint().setFakeBoldText(true);
        if (i <= 10) {
            this.bmT.setBackgroundResource(a.f.sdk_icon_live_im_level1);
        } else if (i <= 20) {
            this.bmT.setBackgroundResource(a.f.sdk_icon_live_im_level2);
        } else if (i <= 30) {
            this.bmT.setBackgroundResource(a.f.sdk_icon_live_im_level3);
        } else if (i <= 40) {
            this.bmT.setBackgroundResource(a.f.sdk_icon_live_im_level4);
        } else {
            this.bmT.setBackgroundResource(a.f.sdk_icon_live_im_level5);
        }
        this.bmZ++;
    }

    public void setupLevelIconImage(int i) {
        if (this.bmR == null) {
            this.bmR = new FrameLayout(getContext());
            this.bmR.setBackgroundColor(0);
        }
        if (this.bmS == null) {
            this.bmS = new ImageView(getContext());
            this.bmS.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
        if (this.bmS.getParent() == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(getResources().getDimensionPixelOffset(a.e.sdk_ds26), getResources().getDimensionPixelOffset(a.e.sdk_ds30));
            layoutParams.gravity = 17;
            this.bmR.addView(this.bmS, layoutParams);
        }
        if (this.bmT == null) {
            this.bmT = new TextView(getContext());
            this.bmT.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
            this.bmT.setTextSize(0, getResources().getDimensionPixelOffset(a.e.sdk_tbfontsize26));
            this.bmT.setGravity(17);
            this.bmT.getPaint().setFakeBoldText(true);
        }
        if (this.bmT.getParent() == null) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 17;
            this.bmR.addView(this.bmT, layoutParams2);
        }
        if (this.bmR.getParent() == null) {
            addView(this.bmR, 0);
        }
        if (i <= 10) {
            this.bmS.setImageResource(a.f.sdk_icon_live_im_level1);
        } else if (i <= 20) {
            this.bmS.setImageResource(a.f.sdk_icon_live_im_level2);
        } else if (i <= 30) {
            this.bmS.setImageResource(a.f.sdk_icon_live_im_level3);
        } else if (i <= 40) {
            this.bmS.setImageResource(a.f.sdk_icon_live_im_level4);
        } else {
            this.bmS.setImageResource(a.f.sdk_icon_live_im_level5);
        }
        this.bmT.setText(i + "");
        this.bmZ++;
    }

    private void setupOfficialIcon(boolean z) {
        if (z) {
            if (this.bmU == null) {
                this.bmU = new TextView(getContext());
                this.bmU.setTextSize(0, getResources().getDimensionPixelSize(a.e.sdk_tbfontsize26));
                this.bmU.setGravity(17);
                this.bmU.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
                this.bmU.setBackgroundResource(a.f.sdk_bg_ala_official);
                this.bmU.setText(a.i.sdk_official);
            }
            if (this.bmU.getParent() == null) {
                addView(this.bmU, i(false, false));
                this.bmZ++;
            }
        } else if (this.bmU != null && this.bmU.getParent() != null) {
            ((ViewGroup) this.bmU.getParent()).removeView(this.bmU);
        }
    }

    private void KD() {
        if (this.bnb == null || this.bnb.type != 2) {
            a(this.bmV);
        } else if (TextUtils.isEmpty(this.bnb.mark_pic)) {
            a(this.bmV);
        } else {
            if (this.bmV == null) {
                this.bmV = new TbImageView(getContext());
                this.bmV.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            } else {
                this.bmV.stopLoad();
            }
            this.bmV.startLoad(this.bnb.mark_pic, 10, false);
            if (this.bmV.getParent() == null) {
                addView(this.bmV, b(false, false, getResources().getDimensionPixelOffset(a.e.sdk_tbds54)));
                this.bmZ++;
            }
        }
    }

    private void a(TbImageView tbImageView) {
        if (tbImageView != null && tbImageView.getParent() != null) {
            ((ViewGroup) tbImageView.getParent()).removeView(tbImageView);
        }
    }

    private void setupClubIcon(int i) {
        String cB = com.baidu.live.guardclub.g.CJ().cB(i);
        if (TextUtils.isEmpty(cB)) {
            a(this.bmW);
            return;
        }
        if (this.bmW == null) {
            this.bmW = new TbImageView(getContext());
            this.bmW.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        } else {
            this.bmW.stopLoad();
        }
        this.bmW.startLoad(cB, 10, false);
        if (this.bmW.getParent() == null) {
            addView(this.bmW, b(false, false, getResources().getDimensionPixelOffset(a.e.sdk_tbds62)));
            this.bmZ++;
        }
    }

    private void E(String str, int i) {
        int i2;
        if (!TextUtils.isEmpty(str)) {
            if (str.length() > 5) {
                str = str.substring(0, 5);
            }
            if (this.bmX == null) {
                this.bmX = new TextView(getContext());
                this.bmX.setTextSize(0, getResources().getDimensionPixelSize(a.e.sdk_tbfontsize26));
                this.bmX.setGravity(17);
                this.bmX.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
            }
            switch (i) {
                case 1:
                    i2 = a.f.sdk_bg_ala_user_type_1;
                    break;
                case 2:
                    i2 = a.f.sdk_bg_ala_user_type_2;
                    break;
                case 3:
                    i2 = a.f.sdk_bg_ala_user_type_3;
                    break;
                default:
                    if (this.bmX != null && this.bmX.getParent() != null) {
                        this.bmX.setBackgroundDrawable(null);
                        ((ViewGroup) this.bmX.getParent()).removeView(this.bmX);
                        return;
                    }
                    return;
            }
            if (this.bmX.getParent() == null) {
                this.bmX.setText(str);
                this.bmX.setBackgroundResource(i2);
                this.bmX.setPadding(this.bmQ, 0, this.bmQ, 6);
                addView(this.bmX, i(false, true));
                this.bna = str.length();
            }
        }
    }

    private ViewGroup.LayoutParams i(boolean z, boolean z2) {
        return b(z, z2, this.bmP);
    }

    private ViewGroup.LayoutParams b(boolean z, boolean z2, int i) {
        if (z2) {
            i = -2;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, this.bmP);
        layoutParams.gravity = 16;
        if (!z) {
            layoutParams.leftMargin = getResources().getDimensionPixelSize(a.e.sdk_tbds10);
        }
        return layoutParams;
    }

    public void KE() {
        if (this.bmY == null) {
            this.bmY = new ImageView(getContext());
            this.bmY.setImageResource(a.f.sdk_icon_live_im_visitors_14);
        }
        if (this.bmY.getParent() == null) {
            addView(this.bmY, i(true, false));
            this.bmZ++;
        }
    }

    public void b(int i, float f) {
        this.bmT.setTextColor(getResources().getColor(i));
        this.bmT.setAlpha(f);
    }

    public int getIconCount() {
        return this.bmZ;
    }

    public int getUserTypeTxtCount() {
        return this.bna;
    }

    public void setTextLayoutParams(int i, int i2, int i3, int i4) {
        if (this.bmT != null) {
            this.bmT.setPadding(i, i2, i3, i4);
        }
    }
}
