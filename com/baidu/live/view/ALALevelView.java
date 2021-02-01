package com.baidu.live.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.data.AlaLiveMarkData;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.ax;
import com.baidu.live.data.df;
import com.baidu.live.data.j;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.widget.TbImageView;
import java.util.List;
/* loaded from: classes11.dex */
public class ALALevelView extends LinearLayout {
    private int bSg;
    private int bSh;
    private FrameLayout bSi;
    private TbImageView bSj;
    private TextView bSk;
    private TextView bSl;
    private TbImageView bSm;
    private TbImageView bSn;
    private TbImageView bSo;
    private TextView bSp;
    private ImageView bSq;
    private int bSr;
    private int bSs;
    private AlaLiveMarkData bSt;
    private AlaLiveMarkData bSu;
    private AlaLiveMarkData bSv;
    private TbImageView bSw;

    public ALALevelView(Context context) {
        super(context);
        this.bSg = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_tbds38);
        this.bSh = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_tbds7);
        init(context);
    }

    public ALALevelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bSg = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_tbds38);
        this.bSh = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_tbds7);
        init(context);
    }

    public ALALevelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bSg = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_tbds38);
        this.bSh = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_tbds7);
        init(context);
    }

    private void init(Context context) {
        setGravity(16);
        setOrientation(0);
    }

    public void setData(ax axVar) {
        if (axVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.bSr = 0;
        this.bSs = 0;
        ao(axVar.live_mark_info_new);
        removeAllViews();
        if (TextUtils.isEmpty(axVar.third_app_id)) {
            setupLevelIcon(axVar.level_id);
            setupOfficialIcon(axVar.is_official == 1);
            Xk();
            Xl();
            return;
        }
        Xn();
    }

    public void setData(j.b bVar) {
        if (bVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.bSr = 0;
        this.bSs = 0;
        ao(bVar.live_mark_info_new);
        an(bVar.live_mark_info_new);
        removeAllViews();
        Xm();
        setupLevelIcon(bVar.level_id);
        Xk();
        Xl();
    }

    public void an(List<AlaLiveMarkData> list) {
        int i;
        this.bSv = null;
        if (list != null) {
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
                    this.bSv = alaLiveMarkData;
                    break;
                }
            }
            if (i >= list.size()) {
                this.bSv = null;
            }
        }
    }

    public void setData(com.baidu.live.data.a aVar) {
        if (aVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        removeAllViews();
        this.bSr = 0;
        this.bSs = 0;
        ao(aVar.aFZ);
        if (TextUtils.isEmpty(aVar.appId)) {
            setupLevelIcon(aVar.level_id);
            setupOfficialIcon(aVar.aFW);
            Xk();
            Xl();
            L(aVar.tagName, aVar.aFY);
            return;
        }
        Xn();
    }

    public void setData(AlaLiveUserInfoData alaLiveUserInfoData) {
        if (alaLiveUserInfoData.isPrivacy != 0) {
            setVisibility(8);
        } else if (alaLiveUserInfoData == null) {
            setVisibility(8);
        } else {
            setVisibility(0);
            this.bSr = 0;
            this.bSs = 0;
            ao(alaLiveUserInfoData.live_mark_info_new);
            removeAllViews();
            setupLevelIconImage(alaLiveUserInfoData.live_mark_info_new, alaLiveUserInfoData.levelId);
            b(alaLiveUserInfoData.clubMemberLevel, alaLiveUserInfoData.clubGuardName, alaLiveUserInfoData.isGold(), alaLiveUserInfoData.guardGoldenType);
            Xk();
            Xl();
        }
    }

    public void setData4Yuyin(AlaLiveUserInfoData alaLiveUserInfoData) {
        if (alaLiveUserInfoData == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.bSr = 0;
        this.bSs = 0;
        ao(alaLiveUserInfoData.live_mark_info_new);
        an(alaLiveUserInfoData.live_mark_info_new);
        removeAllViews();
        setupLevelIconImage(alaLiveUserInfoData.live_mark_info_new, alaLiveUserInfoData.levelId);
        Xm();
        setupClubIcon(alaLiveUserInfoData.clubMemberLevel);
        Xk();
    }

    public void setData4Yuyin(df dfVar) {
        if (dfVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.bSr = 0;
        this.bSs = 0;
        ao(dfVar.live_mark_info_new);
        an(dfVar.live_mark_info_new);
        removeAllViews();
        setupLevelIconImage(dfVar.live_mark_info_new, dfVar.level_id);
        Xm();
        Xk();
    }

    public void ao(List<AlaLiveMarkData> list) {
        this.bSu = null;
        this.bSt = null;
        if (list != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    AlaLiveMarkData alaLiveMarkData = list.get(i2);
                    if (alaLiveMarkData.type == 2) {
                        this.bSu = alaLiveMarkData;
                    } else if (alaLiveMarkData.type == 106) {
                        this.bSt = alaLiveMarkData;
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void setupLevelIcon(List<AlaLiveMarkData> list, int i) {
        setupLevelIconImage(list, i);
    }

    public void setupLevelIcon(int i) {
        if (this.bSk == null) {
            this.bSk = new TextView(getContext());
            this.bSk.setTextSize(0, getResources().getDimensionPixelSize(a.d.sdk_tbfontsize22));
            this.bSk.setGravity(49);
            this.bSk.setPadding(0, getResources().getDimensionPixelSize(a.d.sdk_tbds4), 0, 0);
            this.bSk.setTextColor(getResources().getColor(a.c.sdk_white_alpha100));
        }
        if (this.bSk.getParent() == null) {
            addView(this.bSk, 0);
        }
        this.bSk.setText(i + "");
        this.bSk.getPaint().setFakeBoldText(true);
        if (i <= 10) {
            this.bSk.setBackgroundResource(a.e.sdk_icon_live_im_level1);
        } else if (i <= 20) {
            this.bSk.setBackgroundResource(a.e.sdk_icon_live_im_level2);
        } else if (i <= 30) {
            this.bSk.setBackgroundResource(a.e.sdk_icon_live_im_level3);
        } else if (i <= 40) {
            this.bSk.setBackgroundResource(a.e.sdk_icon_live_im_level4);
        } else {
            this.bSk.setBackgroundResource(a.e.sdk_icon_live_im_level5);
        }
        this.bSr++;
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
                if (this.bSj == null) {
                    this.bSj = new TbImageView(getContext());
                    this.bSj.setScaleType(ImageView.ScaleType.CENTER_CROP);
                } else {
                    this.bSj.stopLoad();
                }
                int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(a.d.sdk_ds32);
                int i3 = (alaLiveMarkData.width <= 0 || alaLiveMarkData.height <= 0) ? dimensionPixelSize : (int) (((1.0f * alaLiveMarkData.width) / alaLiveMarkData.height) * dimensionPixelSize);
                if (this.bSj.getLayoutParams() == null) {
                    layoutParams = new FrameLayout.LayoutParams(i3, dimensionPixelSize);
                    layoutParams.gravity = 17;
                } else {
                    layoutParams = (FrameLayout.LayoutParams) this.bSj.getLayoutParams();
                    layoutParams.width = i3;
                    layoutParams.height = dimensionPixelSize;
                    layoutParams.gravity = 17;
                }
                this.bSj.setLayoutParams(layoutParams);
                if (this.bSi == null) {
                    this.bSi = new FrameLayout(getContext());
                    this.bSi.setBackgroundColor(0);
                }
                if (this.bSj.getParent() == null) {
                    this.bSi.addView(this.bSj);
                }
                this.bSj.startLoad(alaLiveMarkData.mark_pic, 10, false);
                if (this.bSi.getParent() == null) {
                    addView(this.bSi, 0);
                }
                this.bSr++;
            }
        }
    }

    private void setupOfficialIcon(boolean z) {
        if (z) {
            if (this.bSl == null) {
                this.bSl = new TextView(getContext());
                this.bSl.setTextSize(0, getResources().getDimensionPixelSize(a.d.sdk_tbfontsize26));
                this.bSl.setGravity(17);
                this.bSl.setTextColor(getResources().getColor(a.c.sdk_white_alpha100));
                this.bSl.setBackgroundResource(a.e.sdk_bg_ala_official);
                this.bSl.setText(a.h.sdk_official);
            }
            if (this.bSl.getParent() == null) {
                addView(this.bSl, k(false, false));
                this.bSr++;
            }
        } else if (this.bSl != null && this.bSl.getParent() != null) {
            ((ViewGroup) this.bSl.getParent()).removeView(this.bSl);
        }
    }

    private void Xk() {
        if (this.bSu == null || this.bSu.type != 2) {
            a(this.bSn);
        } else if (TextUtils.isEmpty(this.bSu.mark_pic)) {
            a(this.bSn);
        } else {
            if (this.bSn == null) {
                this.bSn = new TbImageView(getContext());
                this.bSn.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            } else {
                this.bSn.stopLoad();
            }
            this.bSn.startLoad(this.bSu.mark_pic, 10, false);
            if (this.bSn.getParent() == null) {
                addView(this.bSn, c(false, false, getResources().getDimensionPixelOffset(a.d.sdk_tbds54)));
                this.bSr++;
            }
        }
    }

    private void Xl() {
        LinearLayout.LayoutParams layoutParams;
        if (this.bSt == null || this.bSt.type != 106) {
            a(this.bSm);
        } else if (TextUtils.isEmpty(this.bSt.mark_pic)) {
            a(this.bSm);
        } else {
            if (this.bSm == null) {
                this.bSm = new TbImageView(getContext());
                this.bSm.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            } else {
                this.bSm.stopLoad();
            }
            this.bSm.startLoad(this.bSt.mark_pic, 10, false);
            if (this.bSm.getParent() == null) {
                int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(a.d.sdk_ds32);
                int i = (this.bSt.width <= 0 || this.bSt.height <= 0) ? dimensionPixelSize : (int) (((1.0f * this.bSt.width) / this.bSt.height) * dimensionPixelSize);
                if (this.bSm.getLayoutParams() == null) {
                    layoutParams = new LinearLayout.LayoutParams(i, dimensionPixelSize);
                    layoutParams.gravity = 17;
                } else {
                    layoutParams = (LinearLayout.LayoutParams) this.bSm.getLayoutParams();
                    layoutParams.width = i;
                    layoutParams.height = dimensionPixelSize;
                    layoutParams.gravity = 17;
                }
                this.bSm.setLayoutParams(layoutParams);
                addView(this.bSm);
                this.bSr++;
            }
        }
    }

    private void Xm() {
        if (this.bSv == null || this.bSv.type != 105) {
            a(this.bSw);
        } else if (TextUtils.isEmpty(this.bSv.mark_pic)) {
            a(this.bSw);
        } else {
            if (this.bSw == null) {
                this.bSw = new TbImageView(getContext());
                this.bSw.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            } else {
                this.bSw.stopLoad();
            }
            this.bSw.startLoad(this.bSv.mark_pic, 10, false);
            if (this.bSw.getParent() == null) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_tbds126), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_tbds60));
                layoutParams.gravity = 16;
                layoutParams.leftMargin = getResources().getDimensionPixelSize(a.d.sdk_tbds10);
                addView(this.bSw, layoutParams);
                this.bSr++;
            }
        }
    }

    private void a(TbImageView tbImageView) {
        if (tbImageView != null && tbImageView.getParent() != null) {
            ((ViewGroup) tbImageView.getParent()).removeView(tbImageView);
        }
    }

    private void b(int i, String str, boolean z, int i2) {
        Bitmap a2 = com.baidu.live.aj.b.a(getContext(), str, i, z, i2);
        if (a2 != null) {
            if (this.bSo == null) {
                this.bSo = new TbImageView(getContext());
                this.bSo.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            }
            this.bSo.setImageBitmap(a2);
            if (this.bSo.getParent() == null) {
                addView(this.bSo, c(false, true, getResources().getDimensionPixelOffset(a.d.sdk_tbds62)));
                this.bSr++;
            }
        }
    }

    private void setupClubIcon(int i) {
        String dq = com.baidu.live.guardclub.g.IT().dq(i);
        if (TextUtils.isEmpty(dq)) {
            a(this.bSo);
            return;
        }
        if (this.bSo == null) {
            this.bSo = new TbImageView(getContext());
            this.bSo.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        } else {
            this.bSo.stopLoad();
        }
        this.bSo.startLoad(dq, 10, false);
        if (this.bSo.getParent() == null) {
            addView(this.bSo, c(false, false, getResources().getDimensionPixelOffset(a.d.sdk_tbds62)));
            this.bSr++;
        }
    }

    private void L(String str, int i) {
        int i2;
        if (!TextUtils.isEmpty(str)) {
            if (str.length() > 5) {
                str = str.substring(0, 5);
            }
            if (this.bSp == null) {
                this.bSp = new TextView(getContext());
                this.bSp.setTextSize(0, getResources().getDimensionPixelSize(a.d.sdk_tbfontsize26));
                this.bSp.setGravity(17);
                this.bSp.setTextColor(getResources().getColor(a.c.sdk_white_alpha100));
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
                    if (this.bSp != null && this.bSp.getParent() != null) {
                        this.bSp.setBackgroundDrawable(null);
                        ((ViewGroup) this.bSp.getParent()).removeView(this.bSp);
                        return;
                    }
                    return;
            }
            if (this.bSp.getParent() == null) {
                this.bSp.setText(str);
                this.bSp.setBackgroundResource(i2);
                this.bSp.setPadding(this.bSh, 0, this.bSh, 6);
                addView(this.bSp, k(false, true));
                this.bSs = str.length();
            }
        }
    }

    private ViewGroup.LayoutParams k(boolean z, boolean z2) {
        return c(z, z2, this.bSg);
    }

    private ViewGroup.LayoutParams c(boolean z, boolean z2, int i) {
        if (z2) {
            i = -2;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, this.bSg);
        layoutParams.gravity = 16;
        if (!z) {
            layoutParams.leftMargin = getResources().getDimensionPixelSize(a.d.sdk_tbds10);
        }
        return layoutParams;
    }

    public void Xn() {
        if (this.bSq == null) {
            this.bSq = new ImageView(getContext());
            this.bSq.setImageResource(a.e.sdk_icon_live_im_visitors_14);
        }
        if (this.bSq.getParent() == null) {
            addView(this.bSq, k(true, false));
            this.bSr++;
        }
    }

    public void b(int i, float f) {
        this.bSk.setTextColor(getResources().getColor(i));
        this.bSk.setAlpha(f);
    }

    public int getIconCount() {
        return this.bSr;
    }

    public int getUserTypeTxtCount() {
        return this.bSs;
    }

    public void setTextLayoutParams(int i, int i2, int i3, int i4) {
        if (this.bSk != null) {
            this.bSk.setPadding(i, i2, i3, i4);
        }
    }
}
