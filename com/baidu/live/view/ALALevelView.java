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
import com.baidu.live.data.z;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.u.a;
import java.util.List;
/* loaded from: classes3.dex */
public class ALALevelView extends LinearLayout {
    private int aZR;
    private int aZS;
    private FrameLayout aZT;
    private ImageView aZU;
    private TextView aZV;
    private TextView aZW;
    private TbImageView aZX;
    private TbImageView aZY;
    private TextView aZZ;
    private ImageView baa;
    private int bab;
    private int bac;
    private AlaLiveMarkData bad;

    public ALALevelView(Context context) {
        super(context);
        this.aZR = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds38);
        this.aZS = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds7);
        init(context);
    }

    public ALALevelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aZR = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds38);
        this.aZS = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds7);
        init(context);
    }

    public ALALevelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aZR = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds38);
        this.aZS = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds7);
        init(context);
    }

    private void init(Context context) {
        setGravity(16);
        setOrientation(0);
    }

    public void setData(z zVar) {
        if (zVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.bab = 0;
        this.bac = 0;
        O(zVar.live_mark_info_new);
        removeAllViews();
        if (TextUtils.isEmpty(zVar.third_app_id)) {
            setupLevelIcon(zVar.level_id);
            setupOfficialIcon(zVar.is_official == 1);
            Hq();
            return;
        }
        Hr();
    }

    public void setData(com.baidu.live.data.a aVar) {
        if (aVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        removeAllViews();
        this.bab = 0;
        this.bac = 0;
        O(aVar.apE);
        if (TextUtils.isEmpty(aVar.appId)) {
            setupLevelIcon(aVar.level_id);
            setupOfficialIcon(aVar.apB);
            Hq();
            A(aVar.tagName, aVar.apD);
            return;
        }
        Hr();
    }

    public void setData(AlaLiveUserInfoData alaLiveUserInfoData) {
        if (alaLiveUserInfoData == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.bab = 0;
        this.bac = 0;
        O(alaLiveUserInfoData.live_mark_info_new);
        removeAllViews();
        setupLevelIconImage(alaLiveUserInfoData.levelId);
        setupClubIcon(alaLiveUserInfoData.clubMemberLevel);
        Hq();
    }

    public void O(List<AlaLiveMarkData> list) {
        if (list != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    AlaLiveMarkData alaLiveMarkData = list.get(i2);
                    if (alaLiveMarkData.type != 2) {
                        i = i2 + 1;
                    } else {
                        this.bad = alaLiveMarkData;
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void setupLevelIcon(int i) {
        if (this.aZV == null) {
            this.aZV = new TextView(getContext());
            this.aZV.setTextSize(0, getResources().getDimensionPixelSize(a.e.sdk_tbfontsize22));
            this.aZV.setGravity(49);
            this.aZV.setPadding(0, getResources().getDimensionPixelSize(a.e.sdk_tbds4), 0, 0);
            this.aZV.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
        }
        if (this.aZV.getParent() == null) {
            addView(this.aZV, 0);
        }
        this.aZV.setText(i + "");
        this.aZV.getPaint().setFakeBoldText(true);
        if (i <= 10) {
            this.aZV.setBackgroundResource(a.f.sdk_icon_live_im_level1);
        } else if (i <= 20) {
            this.aZV.setBackgroundResource(a.f.sdk_icon_live_im_level2);
        } else if (i <= 30) {
            this.aZV.setBackgroundResource(a.f.sdk_icon_live_im_level3);
        } else if (i <= 40) {
            this.aZV.setBackgroundResource(a.f.sdk_icon_live_im_level4);
        } else {
            this.aZV.setBackgroundResource(a.f.sdk_icon_live_im_level5);
        }
        this.bab++;
    }

    public void setupLevelIconImage(int i) {
        if (this.aZT == null) {
            this.aZT = new FrameLayout(getContext());
            this.aZT.setBackgroundColor(0);
        }
        if (this.aZU == null) {
            this.aZU = new ImageView(getContext());
            this.aZU.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
        if (this.aZU.getParent() == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(getResources().getDimensionPixelOffset(a.e.sdk_ds26), getResources().getDimensionPixelOffset(a.e.sdk_ds30));
            layoutParams.gravity = 17;
            this.aZT.addView(this.aZU, layoutParams);
        }
        if (this.aZV == null) {
            this.aZV = new TextView(getContext());
            this.aZV.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
            this.aZV.setTextSize(0, getResources().getDimensionPixelOffset(a.e.sdk_tbfontsize26));
            this.aZV.setGravity(17);
            this.aZV.getPaint().setFakeBoldText(true);
        }
        if (this.aZV.getParent() == null) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 17;
            this.aZT.addView(this.aZV, layoutParams2);
        }
        if (this.aZT.getParent() == null) {
            addView(this.aZT, 0);
        }
        if (i <= 10) {
            this.aZU.setImageResource(a.f.sdk_icon_live_im_level1);
        } else if (i <= 20) {
            this.aZU.setImageResource(a.f.sdk_icon_live_im_level2);
        } else if (i <= 30) {
            this.aZU.setImageResource(a.f.sdk_icon_live_im_level3);
        } else if (i <= 40) {
            this.aZU.setImageResource(a.f.sdk_icon_live_im_level4);
        } else {
            this.aZU.setImageResource(a.f.sdk_icon_live_im_level5);
        }
        this.aZV.setText(i + "");
        this.bab++;
    }

    private void setupOfficialIcon(boolean z) {
        if (z) {
            if (this.aZW == null) {
                this.aZW = new TextView(getContext());
                this.aZW.setTextSize(0, getResources().getDimensionPixelSize(a.e.sdk_tbfontsize26));
                this.aZW.setGravity(17);
                this.aZW.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
                this.aZW.setBackgroundResource(a.f.sdk_bg_ala_official);
                this.aZW.setText(a.i.sdk_official);
            }
            if (this.aZW.getParent() == null) {
                addView(this.aZW, h(false, false));
                this.bab++;
            }
        } else if (this.aZW != null && this.aZW.getParent() != null) {
            ((ViewGroup) this.aZW.getParent()).removeView(this.aZW);
        }
    }

    private void Hq() {
        if (this.bad != null && this.bad.type == 2) {
            if (TextUtils.isEmpty(this.bad.mark_pic)) {
                if (this.aZX != null && this.aZX.getParent() != null) {
                    ((ViewGroup) this.aZX.getParent()).removeView(this.aZX);
                    return;
                }
                return;
            }
            if (this.aZX == null) {
                this.aZX = new TbImageView(getContext());
                this.aZX.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            } else {
                this.aZX.stopLoad();
            }
            this.aZX.startLoad(this.bad.mark_pic, 10, false);
            if (this.aZX.getParent() == null) {
                addView(this.aZX, b(false, false, getResources().getDimensionPixelOffset(a.e.sdk_tbds54)));
                this.bab++;
            }
        }
    }

    private void setupClubIcon(int i) {
        String cg = com.baidu.live.guardclub.g.Ar().cg(i);
        if (TextUtils.isEmpty(cg)) {
            if (this.aZY != null && this.aZY.getParent() != null) {
                ((ViewGroup) this.aZY.getParent()).removeView(this.aZY);
                return;
            }
            return;
        }
        if (this.aZY == null) {
            this.aZY = new TbImageView(getContext());
            this.aZY.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        } else {
            this.aZY.stopLoad();
        }
        this.aZY.startLoad(cg, 10, false);
        if (this.aZY.getParent() == null) {
            addView(this.aZY, b(false, false, getResources().getDimensionPixelOffset(a.e.sdk_tbds62)));
            this.bab++;
        }
    }

    private void A(String str, int i) {
        int i2;
        if (!TextUtils.isEmpty(str)) {
            if (str.length() > 5) {
                str = str.substring(0, 5);
            }
            if (this.aZZ == null) {
                this.aZZ = new TextView(getContext());
                this.aZZ.setTextSize(0, getResources().getDimensionPixelSize(a.e.sdk_tbfontsize26));
                this.aZZ.setGravity(17);
                this.aZZ.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
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
                    if (this.aZZ != null && this.aZZ.getParent() != null) {
                        this.aZZ.setBackgroundDrawable(null);
                        ((ViewGroup) this.aZZ.getParent()).removeView(this.aZZ);
                        return;
                    }
                    return;
            }
            if (this.aZZ.getParent() == null) {
                this.aZZ.setText(str);
                this.aZZ.setBackgroundResource(i2);
                this.aZZ.setPadding(this.aZS, 0, this.aZS, 6);
                addView(this.aZZ, h(false, true));
                this.bac = str.length();
            }
        }
    }

    private ViewGroup.LayoutParams h(boolean z, boolean z2) {
        return b(z, z2, this.aZR);
    }

    private ViewGroup.LayoutParams b(boolean z, boolean z2, int i) {
        if (z2) {
            i = -2;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, this.aZR);
        layoutParams.gravity = 16;
        if (!z) {
            layoutParams.leftMargin = getResources().getDimensionPixelSize(a.e.sdk_tbds10);
        }
        return layoutParams;
    }

    public void Hr() {
        if (this.baa == null) {
            this.baa = new ImageView(getContext());
            this.baa.setImageResource(a.f.sdk_icon_live_im_visitors_14);
        }
        if (this.baa.getParent() == null) {
            addView(this.baa, h(true, false));
            this.bab++;
        }
    }

    public void b(int i, float f) {
        this.aZV.setTextColor(getResources().getColor(i));
        this.aZV.setAlpha(f);
    }

    public int getIconCount() {
        return this.bab;
    }

    public int getUserTypeTxtCount() {
        return this.bac;
    }

    public void setTextLayoutParams(int i, int i2, int i3, int i4) {
        if (this.aZV != null) {
            this.aZV.setPadding(i, i2, i3, i4);
        }
    }
}
