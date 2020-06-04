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
import com.baidu.live.data.ad;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.u.a;
import java.util.List;
/* loaded from: classes3.dex */
public class ALALevelView extends LinearLayout {
    private AlaLiveMarkData bhA;
    private int bho;
    private int bhp;
    private FrameLayout bhq;
    private ImageView bhr;
    private TextView bhs;
    private TextView bht;
    private TbImageView bhu;
    private TbImageView bhv;
    private TextView bhw;
    private ImageView bhx;
    private int bhy;
    private int bhz;

    public ALALevelView(Context context) {
        super(context);
        this.bho = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds38);
        this.bhp = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds7);
        init(context);
    }

    public ALALevelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bho = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds38);
        this.bhp = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds7);
        init(context);
    }

    public ALALevelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bho = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds38);
        this.bhp = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds7);
        init(context);
    }

    private void init(Context context) {
        setGravity(16);
        setOrientation(0);
    }

    public void setData(ad adVar) {
        if (adVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.bhy = 0;
        this.bhz = 0;
        P(adVar.live_mark_info_new);
        removeAllViews();
        if (TextUtils.isEmpty(adVar.third_app_id)) {
            setupLevelIcon(adVar.level_id);
            setupOfficialIcon(adVar.is_official == 1);
            Jj();
            return;
        }
        Jk();
    }

    public void setData(com.baidu.live.data.a aVar) {
        if (aVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        removeAllViews();
        this.bhy = 0;
        this.bhz = 0;
        P(aVar.aux);
        if (TextUtils.isEmpty(aVar.appId)) {
            setupLevelIcon(aVar.level_id);
            setupOfficialIcon(aVar.auu);
            Jj();
            E(aVar.tagName, aVar.auw);
            return;
        }
        Jk();
    }

    public void setData(AlaLiveUserInfoData alaLiveUserInfoData) {
        if (alaLiveUserInfoData == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.bhy = 0;
        this.bhz = 0;
        P(alaLiveUserInfoData.live_mark_info_new);
        removeAllViews();
        setupLevelIconImage(alaLiveUserInfoData.levelId);
        setupClubIcon(alaLiveUserInfoData.clubMemberLevel);
        Jj();
    }

    public void P(List<AlaLiveMarkData> list) {
        int i;
        if (list == null) {
            this.bhA = null;
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
                this.bhA = alaLiveMarkData;
                break;
            }
        }
        if (i >= list.size()) {
            this.bhA = null;
        }
    }

    public void setupLevelIcon(int i) {
        if (this.bhs == null) {
            this.bhs = new TextView(getContext());
            this.bhs.setTextSize(0, getResources().getDimensionPixelSize(a.e.sdk_tbfontsize22));
            this.bhs.setGravity(49);
            this.bhs.setPadding(0, getResources().getDimensionPixelSize(a.e.sdk_tbds4), 0, 0);
            this.bhs.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
        }
        if (this.bhs.getParent() == null) {
            addView(this.bhs, 0);
        }
        this.bhs.setText(i + "");
        this.bhs.getPaint().setFakeBoldText(true);
        if (i <= 10) {
            this.bhs.setBackgroundResource(a.f.sdk_icon_live_im_level1);
        } else if (i <= 20) {
            this.bhs.setBackgroundResource(a.f.sdk_icon_live_im_level2);
        } else if (i <= 30) {
            this.bhs.setBackgroundResource(a.f.sdk_icon_live_im_level3);
        } else if (i <= 40) {
            this.bhs.setBackgroundResource(a.f.sdk_icon_live_im_level4);
        } else {
            this.bhs.setBackgroundResource(a.f.sdk_icon_live_im_level5);
        }
        this.bhy++;
    }

    public void setupLevelIconImage(int i) {
        if (this.bhq == null) {
            this.bhq = new FrameLayout(getContext());
            this.bhq.setBackgroundColor(0);
        }
        if (this.bhr == null) {
            this.bhr = new ImageView(getContext());
            this.bhr.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
        if (this.bhr.getParent() == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(getResources().getDimensionPixelOffset(a.e.sdk_ds26), getResources().getDimensionPixelOffset(a.e.sdk_ds30));
            layoutParams.gravity = 17;
            this.bhq.addView(this.bhr, layoutParams);
        }
        if (this.bhs == null) {
            this.bhs = new TextView(getContext());
            this.bhs.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
            this.bhs.setTextSize(0, getResources().getDimensionPixelOffset(a.e.sdk_tbfontsize26));
            this.bhs.setGravity(17);
            this.bhs.getPaint().setFakeBoldText(true);
        }
        if (this.bhs.getParent() == null) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 17;
            this.bhq.addView(this.bhs, layoutParams2);
        }
        if (this.bhq.getParent() == null) {
            addView(this.bhq, 0);
        }
        if (i <= 10) {
            this.bhr.setImageResource(a.f.sdk_icon_live_im_level1);
        } else if (i <= 20) {
            this.bhr.setImageResource(a.f.sdk_icon_live_im_level2);
        } else if (i <= 30) {
            this.bhr.setImageResource(a.f.sdk_icon_live_im_level3);
        } else if (i <= 40) {
            this.bhr.setImageResource(a.f.sdk_icon_live_im_level4);
        } else {
            this.bhr.setImageResource(a.f.sdk_icon_live_im_level5);
        }
        this.bhs.setText(i + "");
        this.bhy++;
    }

    private void setupOfficialIcon(boolean z) {
        if (z) {
            if (this.bht == null) {
                this.bht = new TextView(getContext());
                this.bht.setTextSize(0, getResources().getDimensionPixelSize(a.e.sdk_tbfontsize26));
                this.bht.setGravity(17);
                this.bht.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
                this.bht.setBackgroundResource(a.f.sdk_bg_ala_official);
                this.bht.setText(a.i.sdk_official);
            }
            if (this.bht.getParent() == null) {
                addView(this.bht, i(false, false));
                this.bhy++;
            }
        } else if (this.bht != null && this.bht.getParent() != null) {
            ((ViewGroup) this.bht.getParent()).removeView(this.bht);
        }
    }

    private void Jj() {
        if (this.bhA == null || this.bhA.type != 2) {
            a(this.bhu);
        } else if (TextUtils.isEmpty(this.bhA.mark_pic)) {
            a(this.bhu);
        } else {
            if (this.bhu == null) {
                this.bhu = new TbImageView(getContext());
                this.bhu.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            } else {
                this.bhu.stopLoad();
            }
            this.bhu.startLoad(this.bhA.mark_pic, 10, false);
            if (this.bhu.getParent() == null) {
                addView(this.bhu, b(false, false, getResources().getDimensionPixelOffset(a.e.sdk_tbds54)));
                this.bhy++;
            }
        }
    }

    private void a(TbImageView tbImageView) {
        if (tbImageView != null && tbImageView.getParent() != null) {
            ((ViewGroup) tbImageView.getParent()).removeView(tbImageView);
        }
    }

    private void setupClubIcon(int i) {
        String cp = com.baidu.live.guardclub.g.BH().cp(i);
        if (TextUtils.isEmpty(cp)) {
            a(this.bhv);
            return;
        }
        if (this.bhv == null) {
            this.bhv = new TbImageView(getContext());
            this.bhv.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        } else {
            this.bhv.stopLoad();
        }
        this.bhv.startLoad(cp, 10, false);
        if (this.bhv.getParent() == null) {
            addView(this.bhv, b(false, false, getResources().getDimensionPixelOffset(a.e.sdk_tbds62)));
            this.bhy++;
        }
    }

    private void E(String str, int i) {
        int i2;
        if (!TextUtils.isEmpty(str)) {
            if (str.length() > 5) {
                str = str.substring(0, 5);
            }
            if (this.bhw == null) {
                this.bhw = new TextView(getContext());
                this.bhw.setTextSize(0, getResources().getDimensionPixelSize(a.e.sdk_tbfontsize26));
                this.bhw.setGravity(17);
                this.bhw.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
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
                    if (this.bhw != null && this.bhw.getParent() != null) {
                        this.bhw.setBackgroundDrawable(null);
                        ((ViewGroup) this.bhw.getParent()).removeView(this.bhw);
                        return;
                    }
                    return;
            }
            if (this.bhw.getParent() == null) {
                this.bhw.setText(str);
                this.bhw.setBackgroundResource(i2);
                this.bhw.setPadding(this.bhp, 0, this.bhp, 6);
                addView(this.bhw, i(false, true));
                this.bhz = str.length();
            }
        }
    }

    private ViewGroup.LayoutParams i(boolean z, boolean z2) {
        return b(z, z2, this.bho);
    }

    private ViewGroup.LayoutParams b(boolean z, boolean z2, int i) {
        if (z2) {
            i = -2;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, this.bho);
        layoutParams.gravity = 16;
        if (!z) {
            layoutParams.leftMargin = getResources().getDimensionPixelSize(a.e.sdk_tbds10);
        }
        return layoutParams;
    }

    public void Jk() {
        if (this.bhx == null) {
            this.bhx = new ImageView(getContext());
            this.bhx.setImageResource(a.f.sdk_icon_live_im_visitors_14);
        }
        if (this.bhx.getParent() == null) {
            addView(this.bhx, i(true, false));
            this.bhy++;
        }
    }

    public void b(int i, float f) {
        this.bhs.setTextColor(getResources().getColor(i));
        this.bhs.setAlpha(f);
    }

    public int getIconCount() {
        return this.bhy;
    }

    public int getUserTypeTxtCount() {
        return this.bhz;
    }

    public void setTextLayoutParams(int i, int i2, int i3, int i4) {
        if (this.bhs != null) {
            this.bhs.setPadding(i, i2, i3, i4);
        }
    }
}
