package com.baidu.live.gift.biggift;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.util.TextHelper;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
/* loaded from: classes4.dex */
public class AlaBigGiftExtraInfoRevisionView extends FrameLayout {
    private HeadImageView aGa;
    private HeadImageView aYn;
    private FrameLayout aYo;
    private List<HeadImageView> aYp;
    private TextView aYq;
    private Integer aYr;
    private TextView aYs;
    private AlphaAnimation aYt;
    private AlphaAnimation aYu;

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
        if (cVar.bdd != null && cVar.bdd.Ib() == 1) {
            for (int i = 0; i < cVar.bdd.aXJ.size(); i++) {
                if (cVar.bdd.aXJ.get(i).portrait != null) {
                    arrayList.add(cVar.bdd.aXJ.get(i).portrait);
                }
            }
        } else {
            arrayList.clear();
        }
        if (cVar.bdd != null && arrayList.size() != 0) {
            I(arrayList);
            this.aGa.startLoad(arrayList.get(0), 12, false);
            arrayList.remove(0);
            if (arrayList.size() < this.aYp.size()) {
                if (arrayList.size() != 0) {
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        this.aYp.get(i2).startLoad(arrayList.get(i2), 12, false);
                    }
                    int size = arrayList.size();
                    while (true) {
                        int i3 = size;
                        if (i3 >= this.aYp.size()) {
                            break;
                        }
                        this.aYp.get(i3).setVisibility(8);
                        size = i3 + 1;
                    }
                } else {
                    int size2 = arrayList.size();
                    while (true) {
                        int i4 = size2;
                        if (i4 >= this.aYp.size()) {
                            break;
                        }
                        this.aYp.get(i4).setVisibility(8);
                        size2 = i4 + 1;
                    }
                }
                if (cVar.bdd.Ia() != null) {
                    this.aYq.setText(cVar.bdd.Ia());
                }
                if (cVar.bdd.HZ() != null) {
                    this.aYs.setText(cVar.bdd.HZ());
                }
                this.aYs.setTextColor(getContext().getResources().getColor(a.c.sdk_color_ffe918));
                this.aYs.setMaxEms(7);
                return;
            }
            return;
        }
        if (cVar.portrait != null) {
            this.aGa.startLoad(cVar.portrait, 12, false);
            if (this.aYp != null) {
                for (int i5 = 0; i5 < this.aYp.size(); i5++) {
                    this.aYp.get(i5).setVisibility(8);
                }
            }
        }
        if (!TextUtils.isEmpty(cVar.userName)) {
            String str = cVar.userName;
            if (TextHelper.getTextLengthWithEmoji(str) > 20) {
                str = TextHelper.subStringWithEmoji(str, 20) + StringHelper.STRING_MORE;
            }
            this.aYq.setText(str);
        }
        if (cVar.bcN != null) {
            if (TextUtils.isEmpty(cVar.bdf)) {
                this.aYs.setText(getResources().getString(a.h.donate) + cVar.bcN.GY());
                this.aYs.setTextColor(getContext().getResources().getColor(a.c.sdk_white_alpha100));
                this.aYs.setMaxEms(7);
                return;
            }
            this.aYs.setText(cVar.bdf + cVar.bcN.GY());
            this.aYs.setTextColor(getContext().getResources().getColor(a.c.sdk_color_ffe918));
            this.aYs.setMaxEms(cVar.bdf.length() + 5);
        }
    }

    public void IG() {
        setVisibility(0);
        if (this.aYt == null) {
            this.aYt = new AlphaAnimation(0.0f, 1.0f);
            this.aYt.setDuration(500L);
            this.aYt.setFillAfter(true);
        }
        startAnimation(this.aYt);
    }

    public void IH() {
        if (this.aYu == null) {
            this.aYu = new AlphaAnimation(1.0f, 0.0f);
            this.aYu.setDuration(500L);
            this.aYu.setFillAfter(true);
        }
        startAnimation(this.aYu);
    }

    public void onDestroy() {
        setVisibility(8);
        clearAnimation();
        this.aYp.clear();
    }

    public void end() {
        setVisibility(8);
        clearAnimation();
    }

    private void init() {
        setBackgroundColor(0);
        this.aYp = new ArrayList(4);
        this.aYr = 3;
        II();
    }

    private void II() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.g.popup_extra_info_revision_layout, (ViewGroup) this, true);
        this.aGa = (HeadImageView) findViewById(a.f.iv_avatar);
        this.aYo = (FrameLayout) findViewById(a.f.content_frame);
        this.aYp = new ArrayList(3);
        this.aYr = 3;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.aGa.getLayoutParams();
        for (int i = 0; i < this.aYr.intValue(); i++) {
            this.aYn = new HeadImageView(getContext());
            this.aYn.setIsRound(true);
            this.aYn.setAutoChangeStyle(false);
            this.aYn.setDefaultBgResource(a.e.sdk_default_avatar);
            this.aYn.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.aYp.add(this.aYn);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams.width, layoutParams.height);
            layoutParams2.gravity = 5;
            layoutParams2.rightMargin = (layoutParams.width - 12) * (i + 1);
            this.aYo.addView(this.aYp.get(i), layoutParams2);
        }
        this.aYq = (TextView) findViewById(a.f.tv_sender);
        this.aYs = (TextView) findViewById(a.f.tv_tip);
        this.aGa.setScaleType(ImageView.ScaleType.FIT_XY);
        this.aGa.setIsRound(true);
        this.aGa.setAutoChangeStyle(false);
        this.aGa.setDefaultBgResource(a.e.sdk_default_avatar);
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
