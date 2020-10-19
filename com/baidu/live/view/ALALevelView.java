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
import com.baidu.live.data.cl;
import com.baidu.live.data.h;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.widget.TbImageView;
import java.util.List;
/* loaded from: classes4.dex */
public class ALALevelView extends LinearLayout {
    private int bCA;
    private AlaLiveMarkData bCB;
    private AlaLiveMarkData bCC;
    private TbImageView bCD;
    private int bCp;
    private int bCq;
    private FrameLayout bCr;
    private ImageView bCs;
    private TextView bCt;
    private TextView bCu;
    private TbImageView bCv;
    private TbImageView bCw;
    private TextView bCx;
    private ImageView bCy;
    private int bCz;

    public ALALevelView(Context context) {
        super(context);
        this.bCp = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds38);
        this.bCq = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds7);
        init(context);
    }

    public ALALevelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bCp = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds38);
        this.bCq = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds7);
        init(context);
    }

    public ALALevelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bCp = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds38);
        this.bCq = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds7);
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
        this.bCz = 0;
        this.bCA = 0;
        ab(amVar.live_mark_info_new);
        removeAllViews();
        if (TextUtils.isEmpty(amVar.third_app_id)) {
            setupLevelIcon(amVar.level_id);
            setupOfficialIcon(amVar.is_official == 1);
            SV();
            return;
        }
        SX();
    }

    public void setData(h.b bVar) {
        if (bVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.bCz = 0;
        this.bCA = 0;
        ab(bVar.live_mark_info_new);
        aa(bVar.live_mark_info_new);
        removeAllViews();
        SW();
        setupLevelIcon(bVar.level_id);
        SV();
    }

    public void aa(List<AlaLiveMarkData> list) {
        int i;
        if (list == null) {
            this.bCC = null;
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
                this.bCC = alaLiveMarkData;
                break;
            }
        }
        if (i >= list.size()) {
            this.bCC = null;
        }
    }

    public void setData(com.baidu.live.data.a aVar) {
        if (aVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        removeAllViews();
        this.bCz = 0;
        this.bCA = 0;
        ab(aVar.aGI);
        if (TextUtils.isEmpty(aVar.appId)) {
            setupLevelIcon(aVar.level_id);
            setupOfficialIcon(aVar.aGF);
            SV();
            F(aVar.tagName, aVar.aGH);
            return;
        }
        SX();
    }

    public void setData(AlaLiveUserInfoData alaLiveUserInfoData) {
        if (alaLiveUserInfoData == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.bCz = 0;
        this.bCA = 0;
        ab(alaLiveUserInfoData.live_mark_info_new);
        removeAllViews();
        setupLevelIconImage(alaLiveUserInfoData.levelId);
        setupClubIcon(alaLiveUserInfoData.clubMemberLevel);
        SV();
    }

    public void setData4Yuyin(AlaLiveUserInfoData alaLiveUserInfoData) {
        if (alaLiveUserInfoData == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.bCz = 0;
        this.bCA = 0;
        ab(alaLiveUserInfoData.live_mark_info_new);
        aa(alaLiveUserInfoData.live_mark_info_new);
        removeAllViews();
        setupLevelIconImage(alaLiveUserInfoData.levelId);
        SW();
        setupClubIcon(alaLiveUserInfoData.clubMemberLevel);
        SV();
    }

    public void setData4Yuyin(cl clVar) {
        if (clVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.bCz = 0;
        this.bCA = 0;
        ab(clVar.live_mark_info_new);
        aa(clVar.live_mark_info_new);
        removeAllViews();
        if (clVar.level_id > 0) {
            setupLevelIconImage(clVar.level_id);
        }
        SW();
        SV();
    }

    public void ab(List<AlaLiveMarkData> list) {
        int i;
        if (list == null) {
            this.bCB = null;
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
                this.bCB = alaLiveMarkData;
                break;
            }
        }
        if (i >= list.size()) {
            this.bCB = null;
        }
    }

    public void setupLevelIcon(int i) {
        if (this.bCt == null) {
            this.bCt = new TextView(getContext());
            this.bCt.setTextSize(0, getResources().getDimensionPixelSize(a.e.sdk_tbfontsize22));
            this.bCt.setGravity(49);
            this.bCt.setPadding(0, getResources().getDimensionPixelSize(a.e.sdk_tbds4), 0, 0);
            this.bCt.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
        }
        if (this.bCt.getParent() == null) {
            addView(this.bCt, 0);
        }
        this.bCt.setText(i + "");
        this.bCt.getPaint().setFakeBoldText(true);
        if (i <= 10) {
            this.bCt.setBackgroundResource(a.f.sdk_icon_live_im_level1);
        } else if (i <= 20) {
            this.bCt.setBackgroundResource(a.f.sdk_icon_live_im_level2);
        } else if (i <= 30) {
            this.bCt.setBackgroundResource(a.f.sdk_icon_live_im_level3);
        } else if (i <= 40) {
            this.bCt.setBackgroundResource(a.f.sdk_icon_live_im_level4);
        } else {
            this.bCt.setBackgroundResource(a.f.sdk_icon_live_im_level5);
        }
        this.bCz++;
    }

    public void setupLevelIconImage(int i) {
        if (this.bCr == null) {
            this.bCr = new FrameLayout(getContext());
            this.bCr.setBackgroundColor(0);
        }
        if (this.bCs == null) {
            this.bCs = new ImageView(getContext());
            this.bCs.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
        if (this.bCs.getParent() == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(getResources().getDimensionPixelOffset(a.e.sdk_ds26), getResources().getDimensionPixelOffset(a.e.sdk_ds30));
            layoutParams.gravity = 17;
            this.bCr.addView(this.bCs, layoutParams);
        }
        if (this.bCt == null) {
            this.bCt = new TextView(getContext());
            this.bCt.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
            this.bCt.setTextSize(0, getResources().getDimensionPixelOffset(a.e.sdk_tbfontsize26));
            this.bCt.setGravity(17);
            this.bCt.getPaint().setFakeBoldText(true);
        }
        if (this.bCt.getParent() == null) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 17;
            this.bCr.addView(this.bCt, layoutParams2);
        }
        if (this.bCr.getParent() == null) {
            addView(this.bCr, 0);
        }
        if (i <= 10) {
            this.bCs.setImageResource(a.f.sdk_icon_live_im_level1);
        } else if (i <= 20) {
            this.bCs.setImageResource(a.f.sdk_icon_live_im_level2);
        } else if (i <= 30) {
            this.bCs.setImageResource(a.f.sdk_icon_live_im_level3);
        } else if (i <= 40) {
            this.bCs.setImageResource(a.f.sdk_icon_live_im_level4);
        } else {
            this.bCs.setImageResource(a.f.sdk_icon_live_im_level5);
        }
        this.bCt.setText(i + "");
        this.bCz++;
    }

    private void setupOfficialIcon(boolean z) {
        if (z) {
            if (this.bCu == null) {
                this.bCu = new TextView(getContext());
                this.bCu.setTextSize(0, getResources().getDimensionPixelSize(a.e.sdk_tbfontsize26));
                this.bCu.setGravity(17);
                this.bCu.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
                this.bCu.setBackgroundResource(a.f.sdk_bg_ala_official);
                this.bCu.setText(a.i.sdk_official);
            }
            if (this.bCu.getParent() == null) {
                addView(this.bCu, j(false, false));
                this.bCz++;
            }
        } else if (this.bCu != null && this.bCu.getParent() != null) {
            ((ViewGroup) this.bCu.getParent()).removeView(this.bCu);
        }
    }

    private void SV() {
        if (this.bCB == null || this.bCB.type != 2) {
            a(this.bCv);
        } else if (TextUtils.isEmpty(this.bCB.mark_pic)) {
            a(this.bCv);
        } else {
            if (this.bCv == null) {
                this.bCv = new TbImageView(getContext());
                this.bCv.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            } else {
                this.bCv.stopLoad();
            }
            this.bCv.startLoad(this.bCB.mark_pic, 10, false);
            if (this.bCv.getParent() == null) {
                addView(this.bCv, b(false, false, getResources().getDimensionPixelOffset(a.e.sdk_tbds54)));
                this.bCz++;
            }
        }
    }

    private void SW() {
        if (this.bCC == null || this.bCC.type != 105) {
            a(this.bCD);
        } else if (TextUtils.isEmpty(this.bCC.mark_pic)) {
            a(this.bCD);
        } else {
            if (this.bCD == null) {
                this.bCD = new TbImageView(getContext());
                this.bCD.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            } else {
                this.bCD.stopLoad();
            }
            this.bCD.startLoad(this.bCC.mark_pic, 10, false);
            if (this.bCD.getParent() == null) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds126), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds60));
                layoutParams.gravity = 16;
                layoutParams.leftMargin = getResources().getDimensionPixelSize(a.e.sdk_tbds10);
                addView(this.bCD, layoutParams);
                this.bCz++;
            }
        }
    }

    private void a(TbImageView tbImageView) {
        if (tbImageView != null && tbImageView.getParent() != null) {
            ((ViewGroup) tbImageView.getParent()).removeView(tbImageView);
        }
    }

    private void setupClubIcon(int i) {
        String eA = com.baidu.live.guardclub.g.JM().eA(i);
        if (TextUtils.isEmpty(eA)) {
            a(this.bCw);
            return;
        }
        if (this.bCw == null) {
            this.bCw = new TbImageView(getContext());
            this.bCw.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        } else {
            this.bCw.stopLoad();
        }
        this.bCw.startLoad(eA, 10, false);
        if (this.bCw.getParent() == null) {
            addView(this.bCw, b(false, false, getResources().getDimensionPixelOffset(a.e.sdk_tbds62)));
            this.bCz++;
        }
    }

    private void F(String str, int i) {
        int i2;
        if (!TextUtils.isEmpty(str)) {
            if (str.length() > 5) {
                str = str.substring(0, 5);
            }
            if (this.bCx == null) {
                this.bCx = new TextView(getContext());
                this.bCx.setTextSize(0, getResources().getDimensionPixelSize(a.e.sdk_tbfontsize26));
                this.bCx.setGravity(17);
                this.bCx.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
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
                    if (this.bCx != null && this.bCx.getParent() != null) {
                        this.bCx.setBackgroundDrawable(null);
                        ((ViewGroup) this.bCx.getParent()).removeView(this.bCx);
                        return;
                    }
                    return;
            }
            if (this.bCx.getParent() == null) {
                this.bCx.setText(str);
                this.bCx.setBackgroundResource(i2);
                this.bCx.setPadding(this.bCq, 0, this.bCq, 6);
                addView(this.bCx, j(false, true));
                this.bCA = str.length();
            }
        }
    }

    private ViewGroup.LayoutParams j(boolean z, boolean z2) {
        return b(z, z2, this.bCp);
    }

    private ViewGroup.LayoutParams b(boolean z, boolean z2, int i) {
        if (z2) {
            i = -2;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, this.bCp);
        layoutParams.gravity = 16;
        if (!z) {
            layoutParams.leftMargin = getResources().getDimensionPixelSize(a.e.sdk_tbds10);
        }
        return layoutParams;
    }

    public void SX() {
        if (this.bCy == null) {
            this.bCy = new ImageView(getContext());
            this.bCy.setImageResource(a.f.sdk_icon_live_im_visitors_14);
        }
        if (this.bCy.getParent() == null) {
            addView(this.bCy, j(true, false));
            this.bCz++;
        }
    }

    public void b(int i, float f) {
        this.bCt.setTextColor(getResources().getColor(i));
        this.bCt.setAlpha(f);
    }

    public int getIconCount() {
        return this.bCz;
    }

    public int getUserTypeTxtCount() {
        return this.bCA;
    }

    public void setTextLayoutParams(int i, int i2, int i3, int i4) {
        if (this.bCt != null) {
            this.bCt.setPadding(i, i2, i3, i4);
        }
    }
}
