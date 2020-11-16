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
    private HeadImageView aDu;
    private HeadImageView aVc;
    private FrameLayout aVd;
    private List<HeadImageView> aVe;
    private TextView aVf;
    private Integer aVg;
    private TextView aVh;
    private AlphaAnimation aVi;
    private AlphaAnimation aVj;

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
        if (cVar.aZE != null && cVar.aZE.Gm() == 1) {
            for (int i = 0; i < cVar.aZE.aUC.size(); i++) {
                if (cVar.aZE.aUC.get(i).portrait != null) {
                    arrayList.add(cVar.aZE.aUC.get(i).portrait);
                }
            }
        } else {
            arrayList.clear();
        }
        if (cVar.aZE != null && arrayList.size() != 0) {
            H(arrayList);
            this.aDu.startLoad(arrayList.get(0), 12, false);
            arrayList.remove(0);
            if (arrayList.size() < this.aVe.size()) {
                if (arrayList.size() != 0) {
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        this.aVe.get(i2).startLoad(arrayList.get(i2), 12, false);
                    }
                    int size = arrayList.size();
                    while (true) {
                        int i3 = size;
                        if (i3 >= this.aVe.size()) {
                            break;
                        }
                        this.aVe.get(i3).setVisibility(8);
                        size = i3 + 1;
                    }
                } else {
                    int size2 = arrayList.size();
                    while (true) {
                        int i4 = size2;
                        if (i4 >= this.aVe.size()) {
                            break;
                        }
                        this.aVe.get(i4).setVisibility(8);
                        size2 = i4 + 1;
                    }
                }
                if (cVar.aZE.Gl() != null) {
                    this.aVf.setText(cVar.aZE.Gl());
                }
                if (cVar.aZE.Gk() != null) {
                    this.aVh.setText(cVar.aZE.Gk());
                    return;
                }
                return;
            }
            return;
        }
        if (cVar.portrait != null) {
            this.aDu.startLoad(cVar.portrait, 12, false);
            if (this.aVe != null) {
                for (int i5 = 0; i5 < this.aVe.size(); i5++) {
                    this.aVe.get(i5).setVisibility(8);
                }
            }
        }
        if (!TextUtils.isEmpty(cVar.userName)) {
            String str = cVar.userName;
            if (TextHelper.getTextLengthWithEmoji(str) > 20) {
                str = TextHelper.subStringWithEmoji(str, 20) + StringHelper.STRING_MORE;
            }
            this.aVf.setText(str);
        }
        if (cVar.aZq != null) {
            this.aVh.setText(getResources().getString(a.h.donate) + cVar.aZq.Fl());
        }
    }

    public void GP() {
        setVisibility(0);
        if (this.aVi == null) {
            this.aVi = new AlphaAnimation(0.0f, 1.0f);
            this.aVi.setDuration(500L);
            this.aVi.setFillAfter(true);
        }
        startAnimation(this.aVi);
    }

    public void GQ() {
        if (this.aVj == null) {
            this.aVj = new AlphaAnimation(1.0f, 0.0f);
            this.aVj.setDuration(500L);
            this.aVj.setFillAfter(true);
        }
        startAnimation(this.aVj);
    }

    public void onDestroy() {
        setVisibility(8);
        clearAnimation();
        this.aVe.clear();
    }

    public void end() {
        setVisibility(8);
        clearAnimation();
    }

    private void init() {
        setBackgroundColor(0);
        this.aVe = new ArrayList(4);
        this.aVg = 3;
        GR();
    }

    private void GR() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.g.popup_extra_info_revision_layout, (ViewGroup) this, true);
        this.aDu = (HeadImageView) findViewById(a.f.iv_avatar);
        this.aVd = (FrameLayout) findViewById(a.f.content_frame);
        this.aVe = new ArrayList(3);
        this.aVg = 3;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.aDu.getLayoutParams();
        for (int i = 0; i < this.aVg.intValue(); i++) {
            this.aVc = new HeadImageView(getContext());
            this.aVc.setIsRound(true);
            this.aVc.setAutoChangeStyle(false);
            this.aVc.setDefaultBgResource(a.e.sdk_default_avatar);
            this.aVc.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.aVe.add(this.aVc);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams.width, layoutParams.height);
            layoutParams2.gravity = 5;
            layoutParams2.rightMargin = (layoutParams.width - 12) * (i + 1);
            this.aVd.addView(this.aVe.get(i), layoutParams2);
        }
        this.aVf = (TextView) findViewById(a.f.tv_sender);
        this.aVh = (TextView) findViewById(a.f.tv_tip);
        this.aDu.setScaleType(ImageView.ScaleType.FIT_XY);
        this.aDu.setIsRound(true);
        this.aDu.setAutoChangeStyle(false);
        this.aDu.setDefaultBgResource(a.e.sdk_default_avatar);
    }

    private void H(List<String> list) {
        LinkedHashSet linkedHashSet = new LinkedHashSet(list.size());
        for (int size = list.size() - 1; size >= 0; size--) {
            linkedHashSet.add(list.get(size));
        }
        list.clear();
        list.addAll(linkedHashSet);
    }
}
