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
    private int aZM;
    private int aZN;
    private FrameLayout aZO;
    private ImageView aZP;
    private TextView aZQ;
    private TextView aZR;
    private TbImageView aZS;
    private TbImageView aZT;
    private TextView aZU;
    private ImageView aZV;
    private int aZW;
    private int aZX;
    private AlaLiveMarkData aZY;

    public ALALevelView(Context context) {
        super(context);
        this.aZM = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds38);
        this.aZN = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds7);
        init(context);
    }

    public ALALevelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aZM = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds38);
        this.aZN = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds7);
        init(context);
    }

    public ALALevelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aZM = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds38);
        this.aZN = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds7);
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
        this.aZW = 0;
        this.aZX = 0;
        O(zVar.live_mark_info_new);
        removeAllViews();
        if (TextUtils.isEmpty(zVar.third_app_id)) {
            setupLevelIcon(zVar.level_id);
            setupOfficialIcon(zVar.is_official == 1);
            Hr();
            return;
        }
        Hs();
    }

    public void setData(com.baidu.live.data.a aVar) {
        if (aVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        removeAllViews();
        this.aZW = 0;
        this.aZX = 0;
        O(aVar.apy);
        if (TextUtils.isEmpty(aVar.appId)) {
            setupLevelIcon(aVar.level_id);
            setupOfficialIcon(aVar.apv);
            Hr();
            A(aVar.tagName, aVar.apx);
            return;
        }
        Hs();
    }

    public void setData(AlaLiveUserInfoData alaLiveUserInfoData) {
        if (alaLiveUserInfoData == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.aZW = 0;
        this.aZX = 0;
        O(alaLiveUserInfoData.live_mark_info_new);
        removeAllViews();
        setupLevelIconImage(alaLiveUserInfoData.levelId);
        setupClubIcon(alaLiveUserInfoData.clubMemberLevel);
        Hr();
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
                        this.aZY = alaLiveMarkData;
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void setupLevelIcon(int i) {
        if (this.aZQ == null) {
            this.aZQ = new TextView(getContext());
            this.aZQ.setTextSize(0, getResources().getDimensionPixelSize(a.e.sdk_tbfontsize22));
            this.aZQ.setGravity(49);
            this.aZQ.setPadding(0, getResources().getDimensionPixelSize(a.e.sdk_tbds4), 0, 0);
            this.aZQ.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
        }
        if (this.aZQ.getParent() == null) {
            addView(this.aZQ, 0);
        }
        this.aZQ.setText(i + "");
        this.aZQ.getPaint().setFakeBoldText(true);
        if (i <= 10) {
            this.aZQ.setBackgroundResource(a.f.sdk_icon_live_im_level1);
        } else if (i <= 20) {
            this.aZQ.setBackgroundResource(a.f.sdk_icon_live_im_level2);
        } else if (i <= 30) {
            this.aZQ.setBackgroundResource(a.f.sdk_icon_live_im_level3);
        } else if (i <= 40) {
            this.aZQ.setBackgroundResource(a.f.sdk_icon_live_im_level4);
        } else {
            this.aZQ.setBackgroundResource(a.f.sdk_icon_live_im_level5);
        }
        this.aZW++;
    }

    public void setupLevelIconImage(int i) {
        if (this.aZO == null) {
            this.aZO = new FrameLayout(getContext());
            this.aZO.setBackgroundColor(0);
        }
        if (this.aZP == null) {
            this.aZP = new ImageView(getContext());
            this.aZP.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
        if (this.aZP.getParent() == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(getResources().getDimensionPixelOffset(a.e.sdk_ds26), getResources().getDimensionPixelOffset(a.e.sdk_ds30));
            layoutParams.gravity = 17;
            this.aZO.addView(this.aZP, layoutParams);
        }
        if (this.aZQ == null) {
            this.aZQ = new TextView(getContext());
            this.aZQ.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
            this.aZQ.setTextSize(0, getResources().getDimensionPixelOffset(a.e.sdk_tbfontsize26));
            this.aZQ.setGravity(17);
            this.aZQ.getPaint().setFakeBoldText(true);
        }
        if (this.aZQ.getParent() == null) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 17;
            this.aZO.addView(this.aZQ, layoutParams2);
        }
        if (this.aZO.getParent() == null) {
            addView(this.aZO, 0);
        }
        if (i <= 10) {
            this.aZP.setImageResource(a.f.sdk_icon_live_im_level1);
        } else if (i <= 20) {
            this.aZP.setImageResource(a.f.sdk_icon_live_im_level2);
        } else if (i <= 30) {
            this.aZP.setImageResource(a.f.sdk_icon_live_im_level3);
        } else if (i <= 40) {
            this.aZP.setImageResource(a.f.sdk_icon_live_im_level4);
        } else {
            this.aZP.setImageResource(a.f.sdk_icon_live_im_level5);
        }
        this.aZQ.setText(i + "");
        this.aZW++;
    }

    private void setupOfficialIcon(boolean z) {
        if (z) {
            if (this.aZR == null) {
                this.aZR = new TextView(getContext());
                this.aZR.setTextSize(0, getResources().getDimensionPixelSize(a.e.sdk_tbfontsize26));
                this.aZR.setGravity(17);
                this.aZR.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
                this.aZR.setBackgroundResource(a.f.sdk_bg_ala_official);
                this.aZR.setText(a.i.sdk_official);
            }
            if (this.aZR.getParent() == null) {
                addView(this.aZR, h(false, false));
                this.aZW++;
            }
        } else if (this.aZR != null && this.aZR.getParent() != null) {
            ((ViewGroup) this.aZR.getParent()).removeView(this.aZR);
        }
    }

    private void Hr() {
        if (this.aZY != null && this.aZY.type == 2) {
            if (TextUtils.isEmpty(this.aZY.mark_pic)) {
                if (this.aZS != null && this.aZS.getParent() != null) {
                    ((ViewGroup) this.aZS.getParent()).removeView(this.aZS);
                    return;
                }
                return;
            }
            if (this.aZS == null) {
                this.aZS = new TbImageView(getContext());
                this.aZS.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            } else {
                this.aZS.stopLoad();
            }
            this.aZS.startLoad(this.aZY.mark_pic, 10, false);
            if (this.aZS.getParent() == null) {
                addView(this.aZS, b(false, false, getResources().getDimensionPixelOffset(a.e.sdk_tbds54)));
                this.aZW++;
            }
        }
    }

    private void setupClubIcon(int i) {
        String cg = com.baidu.live.guardclub.g.As().cg(i);
        if (TextUtils.isEmpty(cg)) {
            if (this.aZT != null && this.aZT.getParent() != null) {
                ((ViewGroup) this.aZT.getParent()).removeView(this.aZT);
                return;
            }
            return;
        }
        if (this.aZT == null) {
            this.aZT = new TbImageView(getContext());
            this.aZT.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        } else {
            this.aZT.stopLoad();
        }
        this.aZT.startLoad(cg, 10, false);
        if (this.aZT.getParent() == null) {
            addView(this.aZT, b(false, false, getResources().getDimensionPixelOffset(a.e.sdk_tbds62)));
            this.aZW++;
        }
    }

    private void A(String str, int i) {
        int i2;
        if (!TextUtils.isEmpty(str)) {
            if (str.length() > 5) {
                str = str.substring(0, 5);
            }
            if (this.aZU == null) {
                this.aZU = new TextView(getContext());
                this.aZU.setTextSize(0, getResources().getDimensionPixelSize(a.e.sdk_tbfontsize26));
                this.aZU.setGravity(17);
                this.aZU.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
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
                    if (this.aZU != null && this.aZU.getParent() != null) {
                        this.aZU.setBackgroundDrawable(null);
                        ((ViewGroup) this.aZU.getParent()).removeView(this.aZU);
                        return;
                    }
                    return;
            }
            if (this.aZU.getParent() == null) {
                this.aZU.setText(str);
                this.aZU.setBackgroundResource(i2);
                this.aZU.setPadding(this.aZN, 0, this.aZN, 6);
                addView(this.aZU, h(false, true));
                this.aZX = str.length();
            }
        }
    }

    private ViewGroup.LayoutParams h(boolean z, boolean z2) {
        return b(z, z2, this.aZM);
    }

    private ViewGroup.LayoutParams b(boolean z, boolean z2, int i) {
        if (z2) {
            i = -2;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, this.aZM);
        layoutParams.gravity = 16;
        if (!z) {
            layoutParams.leftMargin = getResources().getDimensionPixelSize(a.e.sdk_tbds10);
        }
        return layoutParams;
    }

    public void Hs() {
        if (this.aZV == null) {
            this.aZV = new ImageView(getContext());
            this.aZV.setImageResource(a.f.sdk_icon_live_im_visitors_14);
        }
        if (this.aZV.getParent() == null) {
            addView(this.aZV, h(true, false));
            this.aZW++;
        }
    }

    public void b(int i, float f) {
        this.aZQ.setTextColor(getResources().getColor(i));
        this.aZQ.setAlpha(f);
    }

    public int getIconCount() {
        return this.aZW;
    }

    public int getUserTypeTxtCount() {
        return this.aZX;
    }

    public void setTextLayoutParams(int i, int i2, int i3, int i4) {
        if (this.aZQ != null) {
            this.aZQ.setPadding(i, i2, i3, i4);
        }
    }
}
