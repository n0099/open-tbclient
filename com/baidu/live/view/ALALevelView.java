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
import com.baidu.live.data.ap;
import com.baidu.live.data.cr;
import com.baidu.live.data.i;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.widget.TbImageView;
import java.util.List;
/* loaded from: classes4.dex */
public class ALALevelView extends LinearLayout {
    private int bFl;
    private int bFm;
    private FrameLayout bFn;
    private ImageView bFo;
    private TextView bFp;
    private TextView bFq;
    private TbImageView bFr;
    private TbImageView bFs;
    private TextView bFt;
    private ImageView bFu;
    private int bFv;
    private int bFw;
    private AlaLiveMarkData bFx;
    private AlaLiveMarkData bFy;
    private TbImageView bFz;

    public ALALevelView(Context context) {
        super(context);
        this.bFl = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds38);
        this.bFm = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds7);
        init(context);
    }

    public ALALevelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bFl = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds38);
        this.bFm = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds7);
        init(context);
    }

    public ALALevelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bFl = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds38);
        this.bFm = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds7);
        init(context);
    }

    private void init(Context context) {
        setGravity(16);
        setOrientation(0);
    }

    public void setData(ap apVar) {
        if (apVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.bFv = 0;
        this.bFw = 0;
        af(apVar.live_mark_info_new);
        removeAllViews();
        if (TextUtils.isEmpty(apVar.third_app_id)) {
            setupLevelIcon(apVar.level_id);
            setupOfficialIcon(apVar.is_official == 1);
            TU();
            return;
        }
        TW();
    }

    public void setData(i.b bVar) {
        if (bVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.bFv = 0;
        this.bFw = 0;
        af(bVar.live_mark_info_new);
        ae(bVar.live_mark_info_new);
        removeAllViews();
        TV();
        setupLevelIcon(bVar.level_id);
        TU();
    }

    public void ae(List<AlaLiveMarkData> list) {
        int i;
        if (list == null) {
            this.bFy = null;
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
                this.bFy = alaLiveMarkData;
                break;
            }
        }
        if (i >= list.size()) {
            this.bFy = null;
        }
    }

    public void setData(com.baidu.live.data.a aVar) {
        if (aVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        removeAllViews();
        this.bFv = 0;
        this.bFw = 0;
        af(aVar.aGQ);
        if (TextUtils.isEmpty(aVar.appId)) {
            setupLevelIcon(aVar.level_id);
            setupOfficialIcon(aVar.aGN);
            TU();
            F(aVar.tagName, aVar.aGP);
            return;
        }
        TW();
    }

    public void setData(AlaLiveUserInfoData alaLiveUserInfoData) {
        if (alaLiveUserInfoData == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.bFv = 0;
        this.bFw = 0;
        af(alaLiveUserInfoData.live_mark_info_new);
        removeAllViews();
        setupLevelIconImage(alaLiveUserInfoData.levelId);
        setupClubIcon(alaLiveUserInfoData.clubMemberLevel);
        TU();
    }

    public void setData4Yuyin(AlaLiveUserInfoData alaLiveUserInfoData) {
        if (alaLiveUserInfoData == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.bFv = 0;
        this.bFw = 0;
        af(alaLiveUserInfoData.live_mark_info_new);
        ae(alaLiveUserInfoData.live_mark_info_new);
        removeAllViews();
        setupLevelIconImage(alaLiveUserInfoData.levelId);
        TV();
        setupClubIcon(alaLiveUserInfoData.clubMemberLevel);
        TU();
    }

    public void setData4Yuyin(cr crVar) {
        if (crVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.bFv = 0;
        this.bFw = 0;
        af(crVar.live_mark_info_new);
        ae(crVar.live_mark_info_new);
        removeAllViews();
        if (crVar.level_id > 0) {
            setupLevelIconImage(crVar.level_id);
        }
        TV();
        TU();
    }

    public void af(List<AlaLiveMarkData> list) {
        int i;
        if (list == null) {
            this.bFx = null;
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
                this.bFx = alaLiveMarkData;
                break;
            }
        }
        if (i >= list.size()) {
            this.bFx = null;
        }
    }

    public void setupLevelIcon(int i) {
        if (this.bFp == null) {
            this.bFp = new TextView(getContext());
            this.bFp.setTextSize(0, getResources().getDimensionPixelSize(a.e.sdk_tbfontsize22));
            this.bFp.setGravity(49);
            this.bFp.setPadding(0, getResources().getDimensionPixelSize(a.e.sdk_tbds4), 0, 0);
            this.bFp.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
        }
        if (this.bFp.getParent() == null) {
            addView(this.bFp, 0);
        }
        this.bFp.setText(i + "");
        this.bFp.getPaint().setFakeBoldText(true);
        if (i <= 10) {
            this.bFp.setBackgroundResource(a.f.sdk_icon_live_im_level1);
        } else if (i <= 20) {
            this.bFp.setBackgroundResource(a.f.sdk_icon_live_im_level2);
        } else if (i <= 30) {
            this.bFp.setBackgroundResource(a.f.sdk_icon_live_im_level3);
        } else if (i <= 40) {
            this.bFp.setBackgroundResource(a.f.sdk_icon_live_im_level4);
        } else {
            this.bFp.setBackgroundResource(a.f.sdk_icon_live_im_level5);
        }
        this.bFv++;
    }

    public void setupLevelIconImage(int i) {
        if (this.bFn == null) {
            this.bFn = new FrameLayout(getContext());
            this.bFn.setBackgroundColor(0);
        }
        if (this.bFo == null) {
            this.bFo = new ImageView(getContext());
            this.bFo.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
        if (this.bFo.getParent() == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(getResources().getDimensionPixelOffset(a.e.sdk_ds26), getResources().getDimensionPixelOffset(a.e.sdk_ds30));
            layoutParams.gravity = 17;
            this.bFn.addView(this.bFo, layoutParams);
        }
        if (this.bFp == null) {
            this.bFp = new TextView(getContext());
            this.bFp.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
            this.bFp.setTextSize(0, getResources().getDimensionPixelOffset(a.e.sdk_tbfontsize26));
            this.bFp.setGravity(17);
            this.bFp.getPaint().setFakeBoldText(true);
        }
        if (this.bFp.getParent() == null) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 17;
            this.bFn.addView(this.bFp, layoutParams2);
        }
        if (this.bFn.getParent() == null) {
            addView(this.bFn, 0);
        }
        if (i <= 10) {
            this.bFo.setImageResource(a.f.sdk_icon_live_im_level1);
        } else if (i <= 20) {
            this.bFo.setImageResource(a.f.sdk_icon_live_im_level2);
        } else if (i <= 30) {
            this.bFo.setImageResource(a.f.sdk_icon_live_im_level3);
        } else if (i <= 40) {
            this.bFo.setImageResource(a.f.sdk_icon_live_im_level4);
        } else {
            this.bFo.setImageResource(a.f.sdk_icon_live_im_level5);
        }
        this.bFp.setText(i + "");
        this.bFv++;
    }

    private void setupOfficialIcon(boolean z) {
        if (z) {
            if (this.bFq == null) {
                this.bFq = new TextView(getContext());
                this.bFq.setTextSize(0, getResources().getDimensionPixelSize(a.e.sdk_tbfontsize26));
                this.bFq.setGravity(17);
                this.bFq.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
                this.bFq.setBackgroundResource(a.f.sdk_bg_ala_official);
                this.bFq.setText(a.i.sdk_official);
            }
            if (this.bFq.getParent() == null) {
                addView(this.bFq, j(false, false));
                this.bFv++;
            }
        } else if (this.bFq != null && this.bFq.getParent() != null) {
            ((ViewGroup) this.bFq.getParent()).removeView(this.bFq);
        }
    }

    private void TU() {
        if (this.bFx == null || this.bFx.type != 2) {
            a(this.bFr);
        } else if (TextUtils.isEmpty(this.bFx.mark_pic)) {
            a(this.bFr);
        } else {
            if (this.bFr == null) {
                this.bFr = new TbImageView(getContext());
                this.bFr.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            } else {
                this.bFr.stopLoad();
            }
            this.bFr.startLoad(this.bFx.mark_pic, 10, false);
            if (this.bFr.getParent() == null) {
                addView(this.bFr, b(false, false, getResources().getDimensionPixelOffset(a.e.sdk_tbds54)));
                this.bFv++;
            }
        }
    }

    private void TV() {
        if (this.bFy == null || this.bFy.type != 105) {
            a(this.bFz);
        } else if (TextUtils.isEmpty(this.bFy.mark_pic)) {
            a(this.bFz);
        } else {
            if (this.bFz == null) {
                this.bFz = new TbImageView(getContext());
                this.bFz.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            } else {
                this.bFz.stopLoad();
            }
            this.bFz.startLoad(this.bFy.mark_pic, 10, false);
            if (this.bFz.getParent() == null) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds126), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds60));
                layoutParams.gravity = 16;
                layoutParams.leftMargin = getResources().getDimensionPixelSize(a.e.sdk_tbds10);
                addView(this.bFz, layoutParams);
                this.bFv++;
            }
        }
    }

    private void a(TbImageView tbImageView) {
        if (tbImageView != null && tbImageView.getParent() != null) {
            ((ViewGroup) tbImageView.getParent()).removeView(tbImageView);
        }
    }

    private void setupClubIcon(int i) {
        String eB = com.baidu.live.guardclub.g.Kf().eB(i);
        if (TextUtils.isEmpty(eB)) {
            a(this.bFs);
            return;
        }
        if (this.bFs == null) {
            this.bFs = new TbImageView(getContext());
            this.bFs.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        } else {
            this.bFs.stopLoad();
        }
        this.bFs.startLoad(eB, 10, false);
        if (this.bFs.getParent() == null) {
            addView(this.bFs, b(false, false, getResources().getDimensionPixelOffset(a.e.sdk_tbds62)));
            this.bFv++;
        }
    }

    private void F(String str, int i) {
        int i2;
        if (!TextUtils.isEmpty(str)) {
            if (str.length() > 5) {
                str = str.substring(0, 5);
            }
            if (this.bFt == null) {
                this.bFt = new TextView(getContext());
                this.bFt.setTextSize(0, getResources().getDimensionPixelSize(a.e.sdk_tbfontsize26));
                this.bFt.setGravity(17);
                this.bFt.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
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
                    if (this.bFt != null && this.bFt.getParent() != null) {
                        this.bFt.setBackgroundDrawable(null);
                        ((ViewGroup) this.bFt.getParent()).removeView(this.bFt);
                        return;
                    }
                    return;
            }
            if (this.bFt.getParent() == null) {
                this.bFt.setText(str);
                this.bFt.setBackgroundResource(i2);
                this.bFt.setPadding(this.bFm, 0, this.bFm, 6);
                addView(this.bFt, j(false, true));
                this.bFw = str.length();
            }
        }
    }

    private ViewGroup.LayoutParams j(boolean z, boolean z2) {
        return b(z, z2, this.bFl);
    }

    private ViewGroup.LayoutParams b(boolean z, boolean z2, int i) {
        if (z2) {
            i = -2;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, this.bFl);
        layoutParams.gravity = 16;
        if (!z) {
            layoutParams.leftMargin = getResources().getDimensionPixelSize(a.e.sdk_tbds10);
        }
        return layoutParams;
    }

    public void TW() {
        if (this.bFu == null) {
            this.bFu = new ImageView(getContext());
            this.bFu.setImageResource(a.f.sdk_icon_live_im_visitors_14);
        }
        if (this.bFu.getParent() == null) {
            addView(this.bFu, j(true, false));
            this.bFv++;
        }
    }

    public void b(int i, float f) {
        this.bFp.setTextColor(getResources().getColor(i));
        this.bFp.setAlpha(f);
    }

    public int getIconCount() {
        return this.bFv;
    }

    public int getUserTypeTxtCount() {
        return this.bFw;
    }

    public void setTextLayoutParams(int i, int i2, int i3, int i4) {
        if (this.bFp != null) {
            this.bFp.setPadding(i, i2, i3, i4);
        }
    }
}
