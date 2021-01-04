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
/* loaded from: classes11.dex */
public class AlaBigGiftExtraInfoRevisionView extends FrameLayout {
    private HeadImageView aGr;
    private HeadImageView aZT;
    private FrameLayout aZU;
    private List<HeadImageView> aZV;
    private TextView aZW;
    private Integer aZX;
    private TextView aZY;
    private AlphaAnimation aZZ;
    private AlphaAnimation baa;

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
        if (cVar.beL != null && cVar.beL.HC() == 1) {
            for (int i = 0; i < cVar.beL.aZo.size(); i++) {
                if (cVar.beL.aZo.get(i).portrait != null) {
                    arrayList.add(cVar.beL.aZo.get(i).portrait);
                }
            }
        } else {
            arrayList.clear();
        }
        if (cVar.beL != null && arrayList.size() != 0) {
            I(arrayList);
            this.aGr.startLoad(arrayList.get(0), 12, false);
            arrayList.remove(0);
            if (arrayList.size() < this.aZV.size()) {
                if (arrayList.size() != 0) {
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        this.aZV.get(i2).startLoad(arrayList.get(i2), 12, false);
                    }
                    int size = arrayList.size();
                    while (true) {
                        int i3 = size;
                        if (i3 >= this.aZV.size()) {
                            break;
                        }
                        this.aZV.get(i3).setVisibility(8);
                        size = i3 + 1;
                    }
                } else {
                    int size2 = arrayList.size();
                    while (true) {
                        int i4 = size2;
                        if (i4 >= this.aZV.size()) {
                            break;
                        }
                        this.aZV.get(i4).setVisibility(8);
                        size2 = i4 + 1;
                    }
                }
                if (cVar.beL.HB() != null) {
                    this.aZW.setText(cVar.beL.HB());
                }
                if (cVar.beL.HA() != null) {
                    this.aZY.setText(cVar.beL.HA());
                }
                this.aZY.setTextColor(getContext().getResources().getColor(a.c.sdk_color_ffe918));
                this.aZY.setMaxEms(7);
                return;
            }
            return;
        }
        if (cVar.portrait != null) {
            this.aGr.startLoad(cVar.portrait, 12, false);
            if (this.aZV != null) {
                for (int i5 = 0; i5 < this.aZV.size(); i5++) {
                    this.aZV.get(i5).setVisibility(8);
                }
            }
        }
        if (!TextUtils.isEmpty(cVar.userName)) {
            String str = cVar.userName;
            if (TextHelper.getTextLengthWithEmoji(str) > 20) {
                str = TextHelper.subStringWithEmoji(str, 20) + StringHelper.STRING_MORE;
            }
            this.aZW.setText(str);
        }
        if (cVar.bex != null) {
            if (TextUtils.isEmpty(cVar.beN)) {
                this.aZY.setText(getResources().getString(a.h.donate) + cVar.bex.Gy());
                this.aZY.setTextColor(getContext().getResources().getColor(a.c.sdk_white_alpha100));
                this.aZY.setMaxEms(7);
                return;
            }
            this.aZY.setText(cVar.beN + cVar.bex.Gy());
            this.aZY.setTextColor(getContext().getResources().getColor(a.c.sdk_color_ffe918));
            this.aZY.setMaxEms(cVar.beN.length() + 5);
        }
    }

    public void Ii() {
        setVisibility(0);
        if (this.aZZ == null) {
            this.aZZ = new AlphaAnimation(0.0f, 1.0f);
            this.aZZ.setDuration(500L);
            this.aZZ.setFillAfter(true);
        }
        startAnimation(this.aZZ);
    }

    public void Ij() {
        if (this.baa == null) {
            this.baa = new AlphaAnimation(1.0f, 0.0f);
            this.baa.setDuration(500L);
            this.baa.setFillAfter(true);
        }
        startAnimation(this.baa);
    }

    public void onDestroy() {
        setVisibility(8);
        clearAnimation();
        this.aZV.clear();
    }

    public void end() {
        setVisibility(8);
        clearAnimation();
    }

    private void init() {
        setBackgroundColor(0);
        this.aZV = new ArrayList(4);
        this.aZX = 3;
        Ik();
    }

    private void Ik() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.g.popup_extra_info_revision_layout, (ViewGroup) this, true);
        this.aGr = (HeadImageView) findViewById(a.f.iv_avatar);
        this.aZU = (FrameLayout) findViewById(a.f.content_frame);
        this.aZV = new ArrayList(3);
        this.aZX = 3;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.aGr.getLayoutParams();
        for (int i = 0; i < this.aZX.intValue(); i++) {
            this.aZT = new HeadImageView(getContext());
            this.aZT.setIsRound(true);
            this.aZT.setAutoChangeStyle(false);
            this.aZT.setDefaultBgResource(a.e.sdk_default_avatar);
            this.aZT.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.aZV.add(this.aZT);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams.width, layoutParams.height);
            layoutParams2.gravity = 5;
            layoutParams2.rightMargin = (layoutParams.width - 12) * (i + 1);
            this.aZU.addView(this.aZV.get(i), layoutParams2);
        }
        this.aZW = (TextView) findViewById(a.f.tv_sender);
        this.aZY = (TextView) findViewById(a.f.tv_tip);
        this.aGr.setScaleType(ImageView.ScaleType.FIT_XY);
        this.aGr.setIsRound(true);
        this.aGr.setAutoChangeStyle(false);
        this.aGr.setDefaultBgResource(a.e.sdk_default_avatar);
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
