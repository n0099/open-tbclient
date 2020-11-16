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
import com.baidu.live.data.aq;
import com.baidu.live.data.cv;
import com.baidu.live.data.i;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.widget.TbImageView;
import java.util.List;
/* loaded from: classes4.dex */
public class ALALevelView extends LinearLayout {
    private int bJg;
    private int bJh;
    private FrameLayout bJi;
    private TbImageView bJj;
    private TextView bJk;
    private TextView bJl;
    private TbImageView bJm;
    private TbImageView bJn;
    private TextView bJo;
    private ImageView bJp;
    private int bJq;
    private int bJr;
    private AlaLiveMarkData bJs;
    private AlaLiveMarkData bJt;
    private TbImageView bJu;

    public ALALevelView(Context context) {
        super(context);
        this.bJg = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_tbds38);
        this.bJh = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_tbds7);
        init(context);
    }

    public ALALevelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bJg = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_tbds38);
        this.bJh = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_tbds7);
        init(context);
    }

    public ALALevelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bJg = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_tbds38);
        this.bJh = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_tbds7);
        init(context);
    }

    private void init(Context context) {
        setGravity(16);
        setOrientation(0);
    }

    public void setData(aq aqVar) {
        if (aqVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.bJq = 0;
        this.bJr = 0;
        ak(aqVar.live_mark_info_new);
        removeAllViews();
        if (TextUtils.isEmpty(aqVar.third_app_id)) {
            setupLevelIcon(aqVar.level_id);
            setupOfficialIcon(aqVar.is_official == 1);
            VL();
            return;
        }
        VN();
    }

    public void setData(i.b bVar) {
        if (bVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.bJq = 0;
        this.bJr = 0;
        ak(bVar.live_mark_info_new);
        aj(bVar.live_mark_info_new);
        removeAllViews();
        VM();
        setupLevelIcon(bVar.level_id);
        VL();
    }

    public void aj(List<AlaLiveMarkData> list) {
        int i;
        if (list == null) {
            this.bJt = null;
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
                this.bJt = alaLiveMarkData;
                break;
            }
        }
        if (i >= list.size()) {
            this.bJt = null;
        }
    }

    public void setData(com.baidu.live.data.a aVar) {
        if (aVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        removeAllViews();
        this.bJq = 0;
        this.bJr = 0;
        ak(aVar.aFV);
        if (TextUtils.isEmpty(aVar.appId)) {
            setupLevelIcon(aVar.level_id);
            setupOfficialIcon(aVar.aFS);
            VL();
            H(aVar.tagName, aVar.aFU);
            return;
        }
        VN();
    }

    public void setData(AlaLiveUserInfoData alaLiveUserInfoData) {
        if (alaLiveUserInfoData.isPrivacy != 0) {
            setVisibility(8);
        } else if (alaLiveUserInfoData == null) {
            setVisibility(8);
        } else {
            setVisibility(0);
            this.bJq = 0;
            this.bJr = 0;
            ak(alaLiveUserInfoData.live_mark_info_new);
            removeAllViews();
            setupLevelIconImage(alaLiveUserInfoData.live_mark_info_new, alaLiveUserInfoData.levelId);
            setupClubIcon(alaLiveUserInfoData.clubMemberLevel);
            VL();
        }
    }

    public void setData4Yuyin(AlaLiveUserInfoData alaLiveUserInfoData) {
        if (alaLiveUserInfoData == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.bJq = 0;
        this.bJr = 0;
        ak(alaLiveUserInfoData.live_mark_info_new);
        aj(alaLiveUserInfoData.live_mark_info_new);
        removeAllViews();
        setupLevelIconImage(alaLiveUserInfoData.live_mark_info_new, alaLiveUserInfoData.levelId);
        VM();
        setupClubIcon(alaLiveUserInfoData.clubMemberLevel);
        VL();
    }

    public void setData4Yuyin(cv cvVar) {
        if (cvVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.bJq = 0;
        this.bJr = 0;
        ak(cvVar.live_mark_info_new);
        aj(cvVar.live_mark_info_new);
        removeAllViews();
        setupLevelIconImage(cvVar.live_mark_info_new, cvVar.level_id);
        VM();
        VL();
    }

    public void ak(List<AlaLiveMarkData> list) {
        int i;
        if (list == null) {
            this.bJs = null;
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
                this.bJs = alaLiveMarkData;
                break;
            }
        }
        if (i >= list.size()) {
            this.bJs = null;
        }
    }

    public void setupLevelIcon(List<AlaLiveMarkData> list, int i) {
        setupLevelIconImage(list, i);
    }

    public void setupLevelIcon(int i) {
        if (this.bJk == null) {
            this.bJk = new TextView(getContext());
            this.bJk.setTextSize(0, getResources().getDimensionPixelSize(a.d.sdk_tbfontsize22));
            this.bJk.setGravity(49);
            this.bJk.setPadding(0, getResources().getDimensionPixelSize(a.d.sdk_tbds4), 0, 0);
            this.bJk.setTextColor(getResources().getColor(a.c.sdk_white_alpha100));
        }
        if (this.bJk.getParent() == null) {
            addView(this.bJk, 0);
        }
        this.bJk.setText(i + "");
        this.bJk.getPaint().setFakeBoldText(true);
        if (i <= 10) {
            this.bJk.setBackgroundResource(a.e.sdk_icon_live_im_level1);
        } else if (i <= 20) {
            this.bJk.setBackgroundResource(a.e.sdk_icon_live_im_level2);
        } else if (i <= 30) {
            this.bJk.setBackgroundResource(a.e.sdk_icon_live_im_level3);
        } else if (i <= 40) {
            this.bJk.setBackgroundResource(a.e.sdk_icon_live_im_level4);
        } else {
            this.bJk.setBackgroundResource(a.e.sdk_icon_live_im_level5);
        }
        this.bJq++;
    }

    public void setupLevelIconImage(List<AlaLiveMarkData> list, int i) {
        AlaLiveMarkData alaLiveMarkData;
        FrameLayout.LayoutParams layoutParams;
        if (list != null && !list.isEmpty()) {
            int i2 = 0;
            while (true) {
                if (i2 >= list.size()) {
                    alaLiveMarkData = null;
                    break;
                }
                AlaLiveMarkData alaLiveMarkData2 = list.get(i2);
                if (alaLiveMarkData2.type == 1) {
                    alaLiveMarkData = alaLiveMarkData2;
                    break;
                }
                i2++;
            }
            if (alaLiveMarkData != null) {
                alaLiveMarkData.userLevel = i;
                alaLiveMarkData.setupNewLevelMark();
                if (this.bJj == null) {
                    this.bJj = new TbImageView(getContext());
                    this.bJj.setScaleType(ImageView.ScaleType.CENTER_CROP);
                } else {
                    this.bJj.stopLoad();
                }
                int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(a.d.sdk_ds32);
                int i3 = (alaLiveMarkData.width <= 0 || alaLiveMarkData.height <= 0) ? dimensionPixelSize : (int) (((1.0f * alaLiveMarkData.width) / alaLiveMarkData.height) * dimensionPixelSize);
                if (this.bJj.getLayoutParams() == null) {
                    layoutParams = new FrameLayout.LayoutParams(i3, dimensionPixelSize);
                    layoutParams.gravity = 17;
                } else {
                    layoutParams = (FrameLayout.LayoutParams) this.bJj.getLayoutParams();
                    layoutParams.width = i3;
                    layoutParams.height = dimensionPixelSize;
                    layoutParams.gravity = 17;
                }
                this.bJj.setLayoutParams(layoutParams);
                if (this.bJi == null) {
                    this.bJi = new FrameLayout(getContext());
                    this.bJi.setBackgroundColor(0);
                }
                if (this.bJj.getParent() == null) {
                    this.bJi.addView(this.bJj);
                }
                this.bJj.startLoad(alaLiveMarkData.mark_pic, 10, false);
                if (this.bJi.getParent() == null) {
                    addView(this.bJi, 0);
                }
                this.bJq++;
            }
        }
    }

    private void setupOfficialIcon(boolean z) {
        if (z) {
            if (this.bJl == null) {
                this.bJl = new TextView(getContext());
                this.bJl.setTextSize(0, getResources().getDimensionPixelSize(a.d.sdk_tbfontsize26));
                this.bJl.setGravity(17);
                this.bJl.setTextColor(getResources().getColor(a.c.sdk_white_alpha100));
                this.bJl.setBackgroundResource(a.e.sdk_bg_ala_official);
                this.bJl.setText(a.h.sdk_official);
            }
            if (this.bJl.getParent() == null) {
                addView(this.bJl, j(false, false));
                this.bJq++;
            }
        } else if (this.bJl != null && this.bJl.getParent() != null) {
            ((ViewGroup) this.bJl.getParent()).removeView(this.bJl);
        }
    }

    private void VL() {
        if (this.bJs == null || this.bJs.type != 2) {
            a(this.bJm);
        } else if (TextUtils.isEmpty(this.bJs.mark_pic)) {
            a(this.bJm);
        } else {
            if (this.bJm == null) {
                this.bJm = new TbImageView(getContext());
                this.bJm.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            } else {
                this.bJm.stopLoad();
            }
            this.bJm.startLoad(this.bJs.mark_pic, 10, false);
            if (this.bJm.getParent() == null) {
                addView(this.bJm, b(false, false, getResources().getDimensionPixelOffset(a.d.sdk_tbds54)));
                this.bJq++;
            }
        }
    }

    private void VM() {
        if (this.bJt == null || this.bJt.type != 105) {
            a(this.bJu);
        } else if (TextUtils.isEmpty(this.bJt.mark_pic)) {
            a(this.bJu);
        } else {
            if (this.bJu == null) {
                this.bJu = new TbImageView(getContext());
                this.bJu.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            } else {
                this.bJu.stopLoad();
            }
            this.bJu.startLoad(this.bJt.mark_pic, 10, false);
            if (this.bJu.getParent() == null) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_tbds126), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_tbds60));
                layoutParams.gravity = 16;
                layoutParams.leftMargin = getResources().getDimensionPixelSize(a.d.sdk_tbds10);
                addView(this.bJu, layoutParams);
                this.bJq++;
            }
        }
    }

    private void a(TbImageView tbImageView) {
        if (tbImageView != null && tbImageView.getParent() != null) {
            ((ViewGroup) tbImageView.getParent()).removeView(tbImageView);
        }
    }

    private void setupClubIcon(int i) {
        String ex = com.baidu.live.guardclub.g.JW().ex(i);
        if (TextUtils.isEmpty(ex)) {
            a(this.bJn);
            return;
        }
        if (this.bJn == null) {
            this.bJn = new TbImageView(getContext());
            this.bJn.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        } else {
            this.bJn.stopLoad();
        }
        this.bJn.startLoad(ex, 10, false);
        if (this.bJn.getParent() == null) {
            addView(this.bJn, b(false, false, getResources().getDimensionPixelOffset(a.d.sdk_tbds62)));
            this.bJq++;
        }
    }

    private void H(String str, int i) {
        int i2;
        if (!TextUtils.isEmpty(str)) {
            if (str.length() > 5) {
                str = str.substring(0, 5);
            }
            if (this.bJo == null) {
                this.bJo = new TextView(getContext());
                this.bJo.setTextSize(0, getResources().getDimensionPixelSize(a.d.sdk_tbfontsize26));
                this.bJo.setGravity(17);
                this.bJo.setTextColor(getResources().getColor(a.c.sdk_white_alpha100));
            }
            switch (i) {
                case 1:
                    i2 = a.e.sdk_bg_ala_user_type_1;
                    break;
                case 2:
                    i2 = a.e.sdk_bg_ala_user_type_2;
                    break;
                case 3:
                    i2 = a.e.sdk_bg_ala_user_type_3;
                    break;
                default:
                    if (this.bJo != null && this.bJo.getParent() != null) {
                        this.bJo.setBackgroundDrawable(null);
                        ((ViewGroup) this.bJo.getParent()).removeView(this.bJo);
                        return;
                    }
                    return;
            }
            if (this.bJo.getParent() == null) {
                this.bJo.setText(str);
                this.bJo.setBackgroundResource(i2);
                this.bJo.setPadding(this.bJh, 0, this.bJh, 6);
                addView(this.bJo, j(false, true));
                this.bJr = str.length();
            }
        }
    }

    private ViewGroup.LayoutParams j(boolean z, boolean z2) {
        return b(z, z2, this.bJg);
    }

    private ViewGroup.LayoutParams b(boolean z, boolean z2, int i) {
        if (z2) {
            i = -2;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, this.bJg);
        layoutParams.gravity = 16;
        if (!z) {
            layoutParams.leftMargin = getResources().getDimensionPixelSize(a.d.sdk_tbds10);
        }
        return layoutParams;
    }

    public void VN() {
        if (this.bJp == null) {
            this.bJp = new ImageView(getContext());
            this.bJp.setImageResource(a.e.sdk_icon_live_im_visitors_14);
        }
        if (this.bJp.getParent() == null) {
            addView(this.bJp, j(true, false));
            this.bJq++;
        }
    }

    public void b(int i, float f) {
        this.bJk.setTextColor(getResources().getColor(i));
        this.bJk.setAlpha(f);
    }

    public int getIconCount() {
        return this.bJq;
    }

    public int getUserTypeTxtCount() {
        return this.bJr;
    }

    public void setTextLayoutParams(int i, int i2, int i3, int i4) {
        if (this.bJk != null) {
            this.bJk.setPadding(i, i2, i3, i4);
        }
    }
}
