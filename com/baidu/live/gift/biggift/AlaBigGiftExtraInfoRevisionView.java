package com.baidu.live.gift.biggift;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.util.TextHelper;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
/* loaded from: classes10.dex */
public class AlaBigGiftExtraInfoRevisionView extends FrameLayout {
    private HeadImageView aER;
    private HeadImageView aZO;
    private FrameLayout aZP;
    private List<HeadImageView> aZQ;
    private TextView aZR;
    private Integer aZS;
    private TextView aZT;
    private AlphaAnimation aZU;
    private AlphaAnimation aZV;

    public AlaBigGiftExtraInfoRevisionView(Context context) {
        this(context, null);
    }

    public AlaBigGiftExtraInfoRevisionView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setData(com.baidu.live.gift.a.c cVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.clear();
        if (cVar.beE != null && cVar.beE.Fa() == 1) {
            for (int i = 0; i < cVar.beE.aZg.size(); i++) {
                if (cVar.beE.aZg.get(i).portrait != null) {
                    arrayList.add(cVar.beE.aZg.get(i).portrait);
                }
            }
        } else {
            arrayList.clear();
        }
        if (cVar.beE != null && arrayList.size() != 0) {
            I(arrayList);
            this.aER.startLoad(arrayList.get(0), 12, false);
            arrayList.remove(0);
            if (arrayList.size() < this.aZQ.size()) {
                if (arrayList.size() != 0) {
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        this.aZQ.get(i2).startLoad(arrayList.get(i2), 12, false);
                    }
                    int size = arrayList.size();
                    while (true) {
                        int i3 = size;
                        if (i3 >= this.aZQ.size()) {
                            break;
                        }
                        this.aZQ.get(i3).setVisibility(8);
                        size = i3 + 1;
                    }
                } else {
                    int size2 = arrayList.size();
                    while (true) {
                        int i4 = size2;
                        if (i4 >= this.aZQ.size()) {
                            break;
                        }
                        this.aZQ.get(i4).setVisibility(8);
                        size2 = i4 + 1;
                    }
                }
                if (cVar.beE.EZ() != null) {
                    this.aZR.setText(cVar.beE.EZ());
                }
                if (cVar.beE.EY() != null) {
                    this.aZT.setText(cVar.beE.EY());
                }
                this.aZT.setTextColor(getContext().getResources().getColor(a.c.sdk_color_ffe918));
                this.aZT.setMaxEms(7);
                return;
            }
            return;
        }
        if (cVar.portrait != null) {
            this.aER.startLoad(cVar.portrait, 12, false);
            if (this.aZQ != null) {
                for (int i5 = 0; i5 < this.aZQ.size(); i5++) {
                    this.aZQ.get(i5).setVisibility(8);
                }
            }
        }
        if (!TextUtils.isEmpty(cVar.userName)) {
            String str = cVar.userName;
            if (TextHelper.getTextLengthWithEmoji(str) > 20) {
                str = TextHelper.subStringWithEmoji(str, 20) + StringHelper.STRING_MORE;
            }
            this.aZR.setText(str);
        }
        if (cVar.bep != null) {
            if (TextUtils.isEmpty(cVar.beG)) {
                this.aZT.setText(getResources().getString(a.h.donate) + cVar.bep.DV());
                this.aZT.setTextColor(getContext().getResources().getColor(a.c.sdk_white_alpha100));
                this.aZT.setMaxEms(7);
                return;
            }
            this.aZT.setText(cVar.beG + cVar.bep.DV());
            this.aZT.setTextColor(getContext().getResources().getColor(a.c.sdk_color_ffe918));
            this.aZT.setMaxEms(cVar.beG.length() + 5);
        }
    }

    public void FG() {
        setVisibility(0);
        if (this.aZU == null) {
            this.aZU = new AlphaAnimation(0.0f, 1.0f);
            this.aZU.setDuration(500L);
            this.aZU.setFillAfter(true);
        }
        startAnimation(this.aZU);
    }

    public void FH() {
        if (this.aZV == null) {
            this.aZV = new AlphaAnimation(1.0f, 0.0f);
            this.aZV.setDuration(500L);
            this.aZV.setFillAfter(true);
        }
        startAnimation(this.aZV);
    }

    public void onDestroy() {
        setVisibility(8);
        clearAnimation();
        this.aZQ.clear();
    }

    public void end() {
        setVisibility(8);
        clearAnimation();
    }

    private void init() {
        setBackgroundColor(0);
        this.aZQ = new ArrayList(4);
        this.aZS = 3;
        FI();
    }

    private void FI() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.g.popup_extra_info_revision_layout, (ViewGroup) this, true);
        this.aER = (HeadImageView) findViewById(a.f.iv_avatar);
        this.aZP = (FrameLayout) findViewById(a.f.content_frame);
        this.aZQ = new ArrayList(3);
        this.aZS = 3;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.aER.getLayoutParams();
        for (int i = 0; i < this.aZS.intValue(); i++) {
            this.aZO = new HeadImageView(getContext());
            this.aZO.setIsRound(true);
            this.aZO.setAutoChangeStyle(false);
            this.aZO.setDefaultBgResource(a.e.sdk_default_avatar);
            this.aZO.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.aZQ.add(this.aZO);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams.width, layoutParams.height);
            layoutParams2.gravity = 5;
            layoutParams2.rightMargin = (layoutParams.width - 12) * (i + 1);
            this.aZP.addView(this.aZQ.get(i), layoutParams2);
        }
        this.aZR = (TextView) findViewById(a.f.tv_sender);
        this.aZT = (TextView) findViewById(a.f.tv_tip);
        this.aER.setScaleType(ImageView.ScaleType.FIT_XY);
        this.aER.setIsRound(true);
        this.aER.setAutoChangeStyle(false);
        this.aER.setDefaultBgResource(a.e.sdk_default_avatar);
    }

    private void I(List<String> list) {
        LinkedHashSet linkedHashSet = new LinkedHashSet(list.size());
        for (int size = list.size() - 1; size >= 0; size--) {
            linkedHashSet.add(list.get(size));
        }
        list.clear();
        list.addAll(linkedHashSet);
    }
}
