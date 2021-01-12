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
    private HeadImageView aBE;
    private HeadImageView aVg;
    private FrameLayout aVh;
    private List<HeadImageView> aVi;
    private TextView aVj;
    private Integer aVk;
    private TextView aVl;
    private AlphaAnimation aVm;
    private AlphaAnimation aVn;

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
        if (cVar.aZV != null && cVar.aZV.DH() == 1) {
            for (int i = 0; i < cVar.aZV.aUB.size(); i++) {
                if (cVar.aZV.aUB.get(i).portrait != null) {
                    arrayList.add(cVar.aZV.aUB.get(i).portrait);
                }
            }
        } else {
            arrayList.clear();
        }
        if (cVar.aZV != null && arrayList.size() != 0) {
            I(arrayList);
            this.aBE.startLoad(arrayList.get(0), 12, false);
            arrayList.remove(0);
            if (arrayList.size() < this.aVi.size()) {
                if (arrayList.size() != 0) {
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        this.aVi.get(i2).startLoad(arrayList.get(i2), 12, false);
                    }
                    int size = arrayList.size();
                    while (true) {
                        int i3 = size;
                        if (i3 >= this.aVi.size()) {
                            break;
                        }
                        this.aVi.get(i3).setVisibility(8);
                        size = i3 + 1;
                    }
                } else {
                    int size2 = arrayList.size();
                    while (true) {
                        int i4 = size2;
                        if (i4 >= this.aVi.size()) {
                            break;
                        }
                        this.aVi.get(i4).setVisibility(8);
                        size2 = i4 + 1;
                    }
                }
                if (cVar.aZV.DG() != null) {
                    this.aVj.setText(cVar.aZV.DG());
                }
                if (cVar.aZV.DF() != null) {
                    this.aVl.setText(cVar.aZV.DF());
                }
                this.aVl.setTextColor(getContext().getResources().getColor(a.c.sdk_color_ffe918));
                this.aVl.setMaxEms(7);
                return;
            }
            return;
        }
        if (cVar.portrait != null) {
            this.aBE.startLoad(cVar.portrait, 12, false);
            if (this.aVi != null) {
                for (int i5 = 0; i5 < this.aVi.size(); i5++) {
                    this.aVi.get(i5).setVisibility(8);
                }
            }
        }
        if (!TextUtils.isEmpty(cVar.userName)) {
            String str = cVar.userName;
            if (TextHelper.getTextLengthWithEmoji(str) > 20) {
                str = TextHelper.subStringWithEmoji(str, 20) + StringHelper.STRING_MORE;
            }
            this.aVj.setText(str);
        }
        if (cVar.aZH != null) {
            if (TextUtils.isEmpty(cVar.aZX)) {
                this.aVl.setText(getResources().getString(a.h.donate) + cVar.aZH.CD());
                this.aVl.setTextColor(getContext().getResources().getColor(a.c.sdk_white_alpha100));
                this.aVl.setMaxEms(7);
                return;
            }
            this.aVl.setText(cVar.aZX + cVar.aZH.CD());
            this.aVl.setTextColor(getContext().getResources().getColor(a.c.sdk_color_ffe918));
            this.aVl.setMaxEms(cVar.aZX.length() + 5);
        }
    }

    public void En() {
        setVisibility(0);
        if (this.aVm == null) {
            this.aVm = new AlphaAnimation(0.0f, 1.0f);
            this.aVm.setDuration(500L);
            this.aVm.setFillAfter(true);
        }
        startAnimation(this.aVm);
    }

    public void Eo() {
        if (this.aVn == null) {
            this.aVn = new AlphaAnimation(1.0f, 0.0f);
            this.aVn.setDuration(500L);
            this.aVn.setFillAfter(true);
        }
        startAnimation(this.aVn);
    }

    public void onDestroy() {
        setVisibility(8);
        clearAnimation();
        this.aVi.clear();
    }

    public void end() {
        setVisibility(8);
        clearAnimation();
    }

    private void init() {
        setBackgroundColor(0);
        this.aVi = new ArrayList(4);
        this.aVk = 3;
        Ep();
    }

    private void Ep() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.g.popup_extra_info_revision_layout, (ViewGroup) this, true);
        this.aBE = (HeadImageView) findViewById(a.f.iv_avatar);
        this.aVh = (FrameLayout) findViewById(a.f.content_frame);
        this.aVi = new ArrayList(3);
        this.aVk = 3;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.aBE.getLayoutParams();
        for (int i = 0; i < this.aVk.intValue(); i++) {
            this.aVg = new HeadImageView(getContext());
            this.aVg.setIsRound(true);
            this.aVg.setAutoChangeStyle(false);
            this.aVg.setDefaultBgResource(a.e.sdk_default_avatar);
            this.aVg.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.aVi.add(this.aVg);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams.width, layoutParams.height);
            layoutParams2.gravity = 5;
            layoutParams2.rightMargin = (layoutParams.width - 12) * (i + 1);
            this.aVh.addView(this.aVi.get(i), layoutParams2);
        }
        this.aVj = (TextView) findViewById(a.f.tv_sender);
        this.aVl = (TextView) findViewById(a.f.tv_tip);
        this.aBE.setScaleType(ImageView.ScaleType.FIT_XY);
        this.aBE.setIsRound(true);
        this.aBE.setAutoChangeStyle(false);
        this.aBE.setDefaultBgResource(a.e.sdk_default_avatar);
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
