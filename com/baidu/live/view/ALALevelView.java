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
import com.baidu.live.data.am;
import com.baidu.live.data.ck;
import com.baidu.live.data.h;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.widget.TbImageView;
import java.util.List;
/* loaded from: classes4.dex */
public class ALALevelView extends LinearLayout {
    private int bvM;
    private int bvN;
    private FrameLayout bvO;
    private ImageView bvP;
    private TextView bvQ;
    private TextView bvR;
    private TbImageView bvS;
    private TbImageView bvT;
    private TextView bvU;
    private ImageView bvV;
    private int bvW;
    private int bvX;
    private AlaLiveMarkData bvY;
    private AlaLiveMarkData bvZ;
    private TbImageView bwa;

    public ALALevelView(Context context) {
        super(context);
        this.bvM = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds38);
        this.bvN = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds7);
        init(context);
    }

    public ALALevelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bvM = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds38);
        this.bvN = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds7);
        init(context);
    }

    public ALALevelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bvM = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds38);
        this.bvN = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds7);
        init(context);
    }

    private void init(Context context) {
        setGravity(16);
        setOrientation(0);
    }

    public void setData(am amVar) {
        if (amVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.bvW = 0;
        this.bvX = 0;
        Y(amVar.live_mark_info_new);
        removeAllViews();
        if (TextUtils.isEmpty(amVar.third_app_id)) {
            setupLevelIcon(amVar.level_id);
            setupOfficialIcon(amVar.is_official == 1);
            Rd();
            return;
        }
        Rf();
    }

    public void setData(h.b bVar) {
        if (bVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.bvW = 0;
        this.bvX = 0;
        Y(bVar.live_mark_info_new);
        X(bVar.live_mark_info_new);
        removeAllViews();
        Re();
        setupLevelIcon(bVar.level_id);
        Rd();
    }

    public void X(List<AlaLiveMarkData> list) {
        int i;
        if (list == null) {
            this.bvZ = null;
            return;
        }
        int i2 = 0;
        while (true) {
            i = i2;
            if (i >= list.size()) {
                break;
            }
            AlaLiveMarkData alaLiveMarkData = list.get(i);
            if (alaLiveMarkData.type != 105) {
                i2 = i + 1;
            } else {
                this.bvZ = alaLiveMarkData;
                break;
            }
        }
        if (i >= list.size()) {
            this.bvZ = null;
        }
    }

    public void setData(com.baidu.live.data.a aVar) {
        if (aVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        removeAllViews();
        this.bvW = 0;
        this.bvX = 0;
        Y(aVar.aDE);
        if (TextUtils.isEmpty(aVar.appId)) {
            setupLevelIcon(aVar.level_id);
            setupOfficialIcon(aVar.aDB);
            Rd();
            F(aVar.tagName, aVar.aDD);
            return;
        }
        Rf();
    }

    public void setData(AlaLiveUserInfoData alaLiveUserInfoData) {
        if (alaLiveUserInfoData == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.bvW = 0;
        this.bvX = 0;
        Y(alaLiveUserInfoData.live_mark_info_new);
        removeAllViews();
        setupLevelIconImage(alaLiveUserInfoData.levelId);
        setupClubIcon(alaLiveUserInfoData.clubMemberLevel);
        Rd();
    }

    public void setData4Yuyin(AlaLiveUserInfoData alaLiveUserInfoData) {
        if (alaLiveUserInfoData == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.bvW = 0;
        this.bvX = 0;
        Y(alaLiveUserInfoData.live_mark_info_new);
        X(alaLiveUserInfoData.live_mark_info_new);
        removeAllViews();
        setupLevelIconImage(alaLiveUserInfoData.levelId);
        Re();
        setupClubIcon(alaLiveUserInfoData.clubMemberLevel);
        Rd();
    }

    public void setData4Yuyin(ck ckVar) {
        if (ckVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.bvW = 0;
        this.bvX = 0;
        Y(ckVar.live_mark_info_new);
        X(ckVar.live_mark_info_new);
        removeAllViews();
        if (ckVar.level_id > 0) {
            setupLevelIconImage(ckVar.level_id);
        }
        Re();
        Rd();
    }

    public void Y(List<AlaLiveMarkData> list) {
        int i;
        if (list == null) {
            this.bvY = null;
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
                this.bvY = alaLiveMarkData;
                break;
            }
        }
        if (i >= list.size()) {
            this.bvY = null;
        }
    }

    public void setupLevelIcon(int i) {
        if (this.bvQ == null) {
            this.bvQ = new TextView(getContext());
            this.bvQ.setTextSize(0, getResources().getDimensionPixelSize(a.e.sdk_tbfontsize22));
            this.bvQ.setGravity(49);
            this.bvQ.setPadding(0, getResources().getDimensionPixelSize(a.e.sdk_tbds4), 0, 0);
            this.bvQ.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
        }
        if (this.bvQ.getParent() == null) {
            addView(this.bvQ, 0);
        }
        this.bvQ.setText(i + "");
        this.bvQ.getPaint().setFakeBoldText(true);
        if (i <= 10) {
            this.bvQ.setBackgroundResource(a.f.sdk_icon_live_im_level1);
        } else if (i <= 20) {
            this.bvQ.setBackgroundResource(a.f.sdk_icon_live_im_level2);
        } else if (i <= 30) {
            this.bvQ.setBackgroundResource(a.f.sdk_icon_live_im_level3);
        } else if (i <= 40) {
            this.bvQ.setBackgroundResource(a.f.sdk_icon_live_im_level4);
        } else {
            this.bvQ.setBackgroundResource(a.f.sdk_icon_live_im_level5);
        }
        this.bvW++;
    }

    public void setupLevelIconImage(int i) {
        if (this.bvO == null) {
            this.bvO = new FrameLayout(getContext());
            this.bvO.setBackgroundColor(0);
        }
        if (this.bvP == null) {
            this.bvP = new ImageView(getContext());
            this.bvP.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
        if (this.bvP.getParent() == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(getResources().getDimensionPixelOffset(a.e.sdk_ds26), getResources().getDimensionPixelOffset(a.e.sdk_ds30));
            layoutParams.gravity = 17;
            this.bvO.addView(this.bvP, layoutParams);
        }
        if (this.bvQ == null) {
            this.bvQ = new TextView(getContext());
            this.bvQ.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
            this.bvQ.setTextSize(0, getResources().getDimensionPixelOffset(a.e.sdk_tbfontsize26));
            this.bvQ.setGravity(17);
            this.bvQ.getPaint().setFakeBoldText(true);
        }
        if (this.bvQ.getParent() == null) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 17;
            this.bvO.addView(this.bvQ, layoutParams2);
        }
        if (this.bvO.getParent() == null) {
            addView(this.bvO, 0);
        }
        if (i <= 10) {
            this.bvP.setImageResource(a.f.sdk_icon_live_im_level1);
        } else if (i <= 20) {
            this.bvP.setImageResource(a.f.sdk_icon_live_im_level2);
        } else if (i <= 30) {
            this.bvP.setImageResource(a.f.sdk_icon_live_im_level3);
        } else if (i <= 40) {
            this.bvP.setImageResource(a.f.sdk_icon_live_im_level4);
        } else {
            this.bvP.setImageResource(a.f.sdk_icon_live_im_level5);
        }
        this.bvQ.setText(i + "");
        this.bvW++;
    }

    private void setupOfficialIcon(boolean z) {
        if (z) {
            if (this.bvR == null) {
                this.bvR = new TextView(getContext());
                this.bvR.setTextSize(0, getResources().getDimensionPixelSize(a.e.sdk_tbfontsize26));
                this.bvR.setGravity(17);
                this.bvR.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
                this.bvR.setBackgroundResource(a.f.sdk_bg_ala_official);
                this.bvR.setText(a.i.sdk_official);
            }
            if (this.bvR.getParent() == null) {
                addView(this.bvR, j(false, false));
                this.bvW++;
            }
        } else if (this.bvR != null && this.bvR.getParent() != null) {
            ((ViewGroup) this.bvR.getParent()).removeView(this.bvR);
        }
    }

    private void Rd() {
        if (this.bvY == null || this.bvY.type != 2) {
            a(this.bvS);
        } else if (TextUtils.isEmpty(this.bvY.mark_pic)) {
            a(this.bvS);
        } else {
            if (this.bvS == null) {
                this.bvS = new TbImageView(getContext());
                this.bvS.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            } else {
                this.bvS.stopLoad();
            }
            this.bvS.startLoad(this.bvY.mark_pic, 10, false);
            if (this.bvS.getParent() == null) {
                addView(this.bvS, b(false, false, getResources().getDimensionPixelOffset(a.e.sdk_tbds54)));
                this.bvW++;
            }
        }
    }

    private void Re() {
        if (this.bvZ == null || this.bvZ.type != 105) {
            a(this.bwa);
        } else if (TextUtils.isEmpty(this.bvZ.mark_pic)) {
            a(this.bwa);
        } else {
            if (this.bwa == null) {
                this.bwa = new TbImageView(getContext());
                this.bwa.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            } else {
                this.bwa.stopLoad();
            }
            this.bwa.startLoad(this.bvZ.mark_pic, 10, false);
            if (this.bwa.getParent() == null) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds126), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds60));
                layoutParams.gravity = 16;
                layoutParams.leftMargin = getResources().getDimensionPixelSize(a.e.sdk_tbds10);
                addView(this.bwa, layoutParams);
                this.bvW++;
            }
        }
    }

    private void a(TbImageView tbImageView) {
        if (tbImageView != null && tbImageView.getParent() != null) {
            ((ViewGroup) tbImageView.getParent()).removeView(tbImageView);
        }
    }

    private void setupClubIcon(int i) {
        String ev = com.baidu.live.guardclub.g.IP().ev(i);
        if (TextUtils.isEmpty(ev)) {
            a(this.bvT);
            return;
        }
        if (this.bvT == null) {
            this.bvT = new TbImageView(getContext());
            this.bvT.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        } else {
            this.bvT.stopLoad();
        }
        this.bvT.startLoad(ev, 10, false);
        if (this.bvT.getParent() == null) {
            addView(this.bvT, b(false, false, getResources().getDimensionPixelOffset(a.e.sdk_tbds62)));
            this.bvW++;
        }
    }

    private void F(String str, int i) {
        int i2;
        if (!TextUtils.isEmpty(str)) {
            if (str.length() > 5) {
                str = str.substring(0, 5);
            }
            if (this.bvU == null) {
                this.bvU = new TextView(getContext());
                this.bvU.setTextSize(0, getResources().getDimensionPixelSize(a.e.sdk_tbfontsize26));
                this.bvU.setGravity(17);
                this.bvU.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
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
                    if (this.bvU != null && this.bvU.getParent() != null) {
                        this.bvU.setBackgroundDrawable(null);
                        ((ViewGroup) this.bvU.getParent()).removeView(this.bvU);
                        return;
                    }
                    return;
            }
            if (this.bvU.getParent() == null) {
                this.bvU.setText(str);
                this.bvU.setBackgroundResource(i2);
                this.bvU.setPadding(this.bvN, 0, this.bvN, 6);
                addView(this.bvU, j(false, true));
                this.bvX = str.length();
            }
        }
    }

    private ViewGroup.LayoutParams j(boolean z, boolean z2) {
        return b(z, z2, this.bvM);
    }

    private ViewGroup.LayoutParams b(boolean z, boolean z2, int i) {
        if (z2) {
            i = -2;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, this.bvM);
        layoutParams.gravity = 16;
        if (!z) {
            layoutParams.leftMargin = getResources().getDimensionPixelSize(a.e.sdk_tbds10);
        }
        return layoutParams;
    }

    public void Rf() {
        if (this.bvV == null) {
            this.bvV = new ImageView(getContext());
            this.bvV.setImageResource(a.f.sdk_icon_live_im_visitors_14);
        }
        if (this.bvV.getParent() == null) {
            addView(this.bvV, j(true, false));
            this.bvW++;
        }
    }

    public void b(int i, float f) {
        this.bvQ.setTextColor(getResources().getColor(i));
        this.bvQ.setAlpha(f);
    }

    public int getIconCount() {
        return this.bvW;
    }

    public int getUserTypeTxtCount() {
        return this.bvX;
    }

    public void setTextLayoutParams(int i, int i2, int i3, int i4) {
        if (this.bvQ != null) {
            this.bvQ.setPadding(i, i2, i3, i4);
        }
    }
}
