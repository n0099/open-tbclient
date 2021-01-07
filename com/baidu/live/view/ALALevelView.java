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
import com.baidu.live.data.at;
import com.baidu.live.data.cz;
import com.baidu.live.data.j;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.widget.TbImageView;
import java.util.List;
/* loaded from: classes11.dex */
public class ALALevelView extends LinearLayout {
    private int bTc;
    private int bTd;
    private FrameLayout bTe;
    private TbImageView bTf;
    private TextView bTg;
    private TextView bTh;
    private TbImageView bTi;
    private TbImageView bTj;
    private TbImageView bTk;
    private TextView bTl;
    private ImageView bTm;
    private int bTn;
    private int bTo;
    private AlaLiveMarkData bTp;
    private AlaLiveMarkData bTq;
    private AlaLiveMarkData bTr;
    private TbImageView bTs;

    public ALALevelView(Context context) {
        super(context);
        this.bTc = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_tbds38);
        this.bTd = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_tbds7);
        init(context);
    }

    public ALALevelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bTc = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_tbds38);
        this.bTd = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_tbds7);
        init(context);
    }

    public ALALevelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bTc = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_tbds38);
        this.bTd = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_tbds7);
        init(context);
    }

    private void init(Context context) {
        setGravity(16);
        setOrientation(0);
    }

    public void setData(at atVar) {
        if (atVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.bTn = 0;
        this.bTo = 0;
        an(atVar.live_mark_info_new);
        removeAllViews();
        if (TextUtils.isEmpty(atVar.third_app_id)) {
            setupLevelIcon(atVar.level_id);
            setupOfficialIcon(atVar.is_official == 1);
            Zu();
            Zv();
            return;
        }
        Zx();
    }

    public void setData(j.b bVar) {
        if (bVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.bTn = 0;
        this.bTo = 0;
        an(bVar.live_mark_info_new);
        am(bVar.live_mark_info_new);
        removeAllViews();
        Zw();
        setupLevelIcon(bVar.level_id);
        Zu();
        Zv();
    }

    public void am(List<AlaLiveMarkData> list) {
        int i;
        this.bTr = null;
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
                    this.bTr = alaLiveMarkData;
                    break;
                }
            }
            if (i >= list.size()) {
                this.bTr = null;
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
        this.bTn = 0;
        this.bTo = 0;
        an(aVar.aIZ);
        if (TextUtils.isEmpty(aVar.appId)) {
            setupLevelIcon(aVar.level_id);
            setupOfficialIcon(aVar.aIW);
            Zu();
            Zv();
            K(aVar.tagName, aVar.aIY);
            return;
        }
        Zx();
    }

    public void setData(AlaLiveUserInfoData alaLiveUserInfoData) {
        if (alaLiveUserInfoData.isPrivacy != 0) {
            setVisibility(8);
        } else if (alaLiveUserInfoData == null) {
            setVisibility(8);
        } else {
            setVisibility(0);
            this.bTn = 0;
            this.bTo = 0;
            an(alaLiveUserInfoData.live_mark_info_new);
            removeAllViews();
            setupLevelIconImage(alaLiveUserInfoData.live_mark_info_new, alaLiveUserInfoData.levelId);
            a(alaLiveUserInfoData.clubMemberLevel, alaLiveUserInfoData.clubGuardName, alaLiveUserInfoData.isGold(), alaLiveUserInfoData.guardGoldenType);
            Zu();
            Zv();
        }
    }

    public void setData4Yuyin(AlaLiveUserInfoData alaLiveUserInfoData) {
        if (alaLiveUserInfoData == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.bTn = 0;
        this.bTo = 0;
        an(alaLiveUserInfoData.live_mark_info_new);
        am(alaLiveUserInfoData.live_mark_info_new);
        removeAllViews();
        setupLevelIconImage(alaLiveUserInfoData.live_mark_info_new, alaLiveUserInfoData.levelId);
        Zw();
        setupClubIcon(alaLiveUserInfoData.clubMemberLevel);
        Zu();
    }

    public void setData4Yuyin(cz czVar) {
        if (czVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.bTn = 0;
        this.bTo = 0;
        an(czVar.live_mark_info_new);
        am(czVar.live_mark_info_new);
        removeAllViews();
        setupLevelIconImage(czVar.live_mark_info_new, czVar.level_id);
        Zw();
        Zu();
    }

    public void an(List<AlaLiveMarkData> list) {
        this.bTq = null;
        this.bTp = null;
        if (list != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    AlaLiveMarkData alaLiveMarkData = list.get(i2);
                    if (alaLiveMarkData.type == 2) {
                        this.bTq = alaLiveMarkData;
                    } else if (alaLiveMarkData.type == 106) {
                        this.bTp = alaLiveMarkData;
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
        if (this.bTg == null) {
            this.bTg = new TextView(getContext());
            this.bTg.setTextSize(0, getResources().getDimensionPixelSize(a.d.sdk_tbfontsize22));
            this.bTg.setGravity(49);
            this.bTg.setPadding(0, getResources().getDimensionPixelSize(a.d.sdk_tbds4), 0, 0);
            this.bTg.setTextColor(getResources().getColor(a.c.sdk_white_alpha100));
        }
        if (this.bTg.getParent() == null) {
            addView(this.bTg, 0);
        }
        this.bTg.setText(i + "");
        this.bTg.getPaint().setFakeBoldText(true);
        if (i <= 10) {
            this.bTg.setBackgroundResource(a.e.sdk_icon_live_im_level1);
        } else if (i <= 20) {
            this.bTg.setBackgroundResource(a.e.sdk_icon_live_im_level2);
        } else if (i <= 30) {
            this.bTg.setBackgroundResource(a.e.sdk_icon_live_im_level3);
        } else if (i <= 40) {
            this.bTg.setBackgroundResource(a.e.sdk_icon_live_im_level4);
        } else {
            this.bTg.setBackgroundResource(a.e.sdk_icon_live_im_level5);
        }
        this.bTn++;
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
                if (this.bTf == null) {
                    this.bTf = new TbImageView(getContext());
                    this.bTf.setScaleType(ImageView.ScaleType.CENTER_CROP);
                } else {
                    this.bTf.stopLoad();
                }
                int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(a.d.sdk_ds32);
                int i3 = (alaLiveMarkData.width <= 0 || alaLiveMarkData.height <= 0) ? dimensionPixelSize : (int) (((1.0f * alaLiveMarkData.width) / alaLiveMarkData.height) * dimensionPixelSize);
                if (this.bTf.getLayoutParams() == null) {
                    layoutParams = new FrameLayout.LayoutParams(i3, dimensionPixelSize);
                    layoutParams.gravity = 17;
                } else {
                    layoutParams = (FrameLayout.LayoutParams) this.bTf.getLayoutParams();
                    layoutParams.width = i3;
                    layoutParams.height = dimensionPixelSize;
                    layoutParams.gravity = 17;
                }
                this.bTf.setLayoutParams(layoutParams);
                if (this.bTe == null) {
                    this.bTe = new FrameLayout(getContext());
                    this.bTe.setBackgroundColor(0);
                }
                if (this.bTf.getParent() == null) {
                    this.bTe.addView(this.bTf);
                }
                this.bTf.startLoad(alaLiveMarkData.mark_pic, 10, false);
                if (this.bTe.getParent() == null) {
                    addView(this.bTe, 0);
                }
                this.bTn++;
            }
        }
    }

    private void setupOfficialIcon(boolean z) {
        if (z) {
            if (this.bTh == null) {
                this.bTh = new TextView(getContext());
                this.bTh.setTextSize(0, getResources().getDimensionPixelSize(a.d.sdk_tbfontsize26));
                this.bTh.setGravity(17);
                this.bTh.setTextColor(getResources().getColor(a.c.sdk_white_alpha100));
                this.bTh.setBackgroundResource(a.e.sdk_bg_ala_official);
                this.bTh.setText(a.h.sdk_official);
            }
            if (this.bTh.getParent() == null) {
                addView(this.bTh, j(false, false));
                this.bTn++;
            }
        } else if (this.bTh != null && this.bTh.getParent() != null) {
            ((ViewGroup) this.bTh.getParent()).removeView(this.bTh);
        }
    }

    private void Zu() {
        if (this.bTq == null || this.bTq.type != 2) {
            a(this.bTj);
        } else if (TextUtils.isEmpty(this.bTq.mark_pic)) {
            a(this.bTj);
        } else {
            if (this.bTj == null) {
                this.bTj = new TbImageView(getContext());
                this.bTj.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            } else {
                this.bTj.stopLoad();
            }
            this.bTj.startLoad(this.bTq.mark_pic, 10, false);
            if (this.bTj.getParent() == null) {
                addView(this.bTj, c(false, false, getResources().getDimensionPixelOffset(a.d.sdk_tbds54)));
                this.bTn++;
            }
        }
    }

    private void Zv() {
        LinearLayout.LayoutParams layoutParams;
        if (this.bTp == null || this.bTp.type != 106) {
            a(this.bTi);
        } else if (TextUtils.isEmpty(this.bTp.mark_pic)) {
            a(this.bTi);
        } else {
            if (this.bTi == null) {
                this.bTi = new TbImageView(getContext());
                this.bTi.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            } else {
                this.bTi.stopLoad();
            }
            this.bTi.startLoad(this.bTp.mark_pic, 10, false);
            if (this.bTi.getParent() == null) {
                int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(a.d.sdk_ds32);
                int i = (this.bTp.width <= 0 || this.bTp.height <= 0) ? dimensionPixelSize : (int) (((1.0f * this.bTp.width) / this.bTp.height) * dimensionPixelSize);
                if (this.bTi.getLayoutParams() == null) {
                    layoutParams = new LinearLayout.LayoutParams(i, dimensionPixelSize);
                    layoutParams.gravity = 17;
                } else {
                    layoutParams = (LinearLayout.LayoutParams) this.bTi.getLayoutParams();
                    layoutParams.width = i;
                    layoutParams.height = dimensionPixelSize;
                    layoutParams.gravity = 17;
                }
                this.bTi.setLayoutParams(layoutParams);
                addView(this.bTi);
                this.bTn++;
            }
        }
    }

    private void Zw() {
        if (this.bTr == null || this.bTr.type != 105) {
            a(this.bTs);
        } else if (TextUtils.isEmpty(this.bTr.mark_pic)) {
            a(this.bTs);
        } else {
            if (this.bTs == null) {
                this.bTs = new TbImageView(getContext());
                this.bTs.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            } else {
                this.bTs.stopLoad();
            }
            this.bTs.startLoad(this.bTr.mark_pic, 10, false);
            if (this.bTs.getParent() == null) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_tbds126), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_tbds60));
                layoutParams.gravity = 16;
                layoutParams.leftMargin = getResources().getDimensionPixelSize(a.d.sdk_tbds10);
                addView(this.bTs, layoutParams);
                this.bTn++;
            }
        }
    }

    private void a(TbImageView tbImageView) {
        if (tbImageView != null && tbImageView.getParent() != null) {
            ((ViewGroup) tbImageView.getParent()).removeView(tbImageView);
        }
    }

    private void a(int i, String str, boolean z, int i2) {
        Bitmap a2 = com.baidu.live.al.b.a(getContext(), str, i, z, i2);
        if (a2 != null) {
            if (this.bTk == null) {
                this.bTk = new TbImageView(getContext());
                this.bTk.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            }
            this.bTk.setImageBitmap(a2);
            if (this.bTk.getParent() == null) {
                addView(this.bTk, c(false, true, getResources().getDimensionPixelOffset(a.d.sdk_tbds62)));
                this.bTn++;
            }
        }
    }

    private void setupClubIcon(int i) {
        String eR = com.baidu.live.guardclub.g.Ly().eR(i);
        if (TextUtils.isEmpty(eR)) {
            a(this.bTk);
            return;
        }
        if (this.bTk == null) {
            this.bTk = new TbImageView(getContext());
            this.bTk.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        } else {
            this.bTk.stopLoad();
        }
        this.bTk.startLoad(eR, 10, false);
        if (this.bTk.getParent() == null) {
            addView(this.bTk, c(false, false, getResources().getDimensionPixelOffset(a.d.sdk_tbds62)));
            this.bTn++;
        }
    }

    private void K(String str, int i) {
        int i2;
        if (!TextUtils.isEmpty(str)) {
            if (str.length() > 5) {
                str = str.substring(0, 5);
            }
            if (this.bTl == null) {
                this.bTl = new TextView(getContext());
                this.bTl.setTextSize(0, getResources().getDimensionPixelSize(a.d.sdk_tbfontsize26));
                this.bTl.setGravity(17);
                this.bTl.setTextColor(getResources().getColor(a.c.sdk_white_alpha100));
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
                    if (this.bTl != null && this.bTl.getParent() != null) {
                        this.bTl.setBackgroundDrawable(null);
                        ((ViewGroup) this.bTl.getParent()).removeView(this.bTl);
                        return;
                    }
                    return;
            }
            if (this.bTl.getParent() == null) {
                this.bTl.setText(str);
                this.bTl.setBackgroundResource(i2);
                this.bTl.setPadding(this.bTd, 0, this.bTd, 6);
                addView(this.bTl, j(false, true));
                this.bTo = str.length();
            }
        }
    }

    private ViewGroup.LayoutParams j(boolean z, boolean z2) {
        return c(z, z2, this.bTc);
    }

    private ViewGroup.LayoutParams c(boolean z, boolean z2, int i) {
        if (z2) {
            i = -2;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, this.bTc);
        layoutParams.gravity = 16;
        if (!z) {
            layoutParams.leftMargin = getResources().getDimensionPixelSize(a.d.sdk_tbds10);
        }
        return layoutParams;
    }

    public void Zx() {
        if (this.bTm == null) {
            this.bTm = new ImageView(getContext());
            this.bTm.setImageResource(a.e.sdk_icon_live_im_visitors_14);
        }
        if (this.bTm.getParent() == null) {
            addView(this.bTm, j(true, false));
            this.bTn++;
        }
    }

    public void b(int i, float f) {
        this.bTg.setTextColor(getResources().getColor(i));
        this.bTg.setAlpha(f);
    }

    public int getIconCount() {
        return this.bTn;
    }

    public int getUserTypeTxtCount() {
        return this.bTo;
    }

    public void setTextLayoutParams(int i, int i2, int i3, int i4) {
        if (this.bTg != null) {
            this.bTg.setPadding(i, i2, i3, i4);
        }
    }
}
