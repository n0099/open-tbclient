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
    private HeadImageView aEp;
    private TextView aVA;
    private AlphaAnimation aVB;
    private AlphaAnimation aVC;
    private HeadImageView aVv;
    private FrameLayout aVw;
    private List<HeadImageView> aVx;
    private TextView aVy;
    private Integer aVz;

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
        if (cVar.aZX != null && cVar.aZX.Gu() == 1) {
            for (int i = 0; i < cVar.aZX.aUV.size(); i++) {
                if (cVar.aZX.aUV.get(i).portrait != null) {
                    arrayList.add(cVar.aZX.aUV.get(i).portrait);
                }
            }
        } else {
            arrayList.clear();
        }
        if (cVar.aZX != null && arrayList.size() != 0) {
            H(arrayList);
            this.aEp.startLoad(arrayList.get(0), 12, false);
            arrayList.remove(0);
            if (arrayList.size() < this.aVx.size()) {
                if (arrayList.size() != 0) {
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        this.aVx.get(i2).startLoad(arrayList.get(i2), 12, false);
                    }
                    int size = arrayList.size();
                    while (true) {
                        int i3 = size;
                        if (i3 >= this.aVx.size()) {
                            break;
                        }
                        this.aVx.get(i3).setVisibility(8);
                        size = i3 + 1;
                    }
                } else {
                    int size2 = arrayList.size();
                    while (true) {
                        int i4 = size2;
                        if (i4 >= this.aVx.size()) {
                            break;
                        }
                        this.aVx.get(i4).setVisibility(8);
                        size2 = i4 + 1;
                    }
                }
                if (cVar.aZX.Gt() != null) {
                    this.aVy.setText(cVar.aZX.Gt());
                }
                if (cVar.aZX.Gs() != null) {
                    this.aVA.setText(cVar.aZX.Gs());
                    return;
                }
                return;
            }
            return;
        }
        if (cVar.portrait != null) {
            this.aEp.startLoad(cVar.portrait, 12, false);
            if (this.aVx != null) {
                for (int i5 = 0; i5 < this.aVx.size(); i5++) {
                    this.aVx.get(i5).setVisibility(8);
                }
            }
        }
        if (!TextUtils.isEmpty(cVar.userName)) {
            String str = cVar.userName;
            if (TextHelper.getTextLengthWithEmoji(str) > 20) {
                str = TextHelper.subStringWithEmoji(str, 20) + StringHelper.STRING_MORE;
            }
            this.aVy.setText(str);
        }
        if (cVar.aZJ != null) {
            this.aVA.setText(getResources().getString(a.i.donate) + cVar.aZJ.Ft());
        }
    }

    public void GX() {
        setVisibility(0);
        if (this.aVB == null) {
            this.aVB = new AlphaAnimation(0.0f, 1.0f);
            this.aVB.setDuration(500L);
            this.aVB.setFillAfter(true);
        }
        startAnimation(this.aVB);
    }

    public void GY() {
        if (this.aVC == null) {
            this.aVC = new AlphaAnimation(1.0f, 0.0f);
            this.aVC.setDuration(500L);
            this.aVC.setFillAfter(true);
        }
        startAnimation(this.aVC);
    }

    public void onDestroy() {
        setVisibility(8);
        clearAnimation();
        this.aVx.clear();
    }

    public void end() {
        setVisibility(8);
        clearAnimation();
    }

    private void init() {
        setBackgroundColor(0);
        this.aVx = new ArrayList(4);
        this.aVz = 3;
        GZ();
    }

    private void GZ() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.h.popup_extra_info_revision_layout, (ViewGroup) this, true);
        this.aEp = (HeadImageView) findViewById(a.g.iv_avatar);
        this.aVw = (FrameLayout) findViewById(a.g.content_frame);
        this.aVx = new ArrayList(3);
        this.aVz = 3;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.aEp.getLayoutParams();
        for (int i = 0; i < this.aVz.intValue(); i++) {
            this.aVv = new HeadImageView(getContext());
            this.aVv.setIsRound(true);
            this.aVv.setAutoChangeStyle(false);
            this.aVv.setDefaultBgResource(a.f.sdk_default_avatar);
            this.aVv.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.aVx.add(this.aVv);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams.width, layoutParams.height);
            layoutParams2.gravity = 5;
            layoutParams2.rightMargin = (layoutParams.width - 12) * (i + 1);
            this.aVw.addView(this.aVx.get(i), layoutParams2);
        }
        this.aVy = (TextView) findViewById(a.g.tv_sender);
        this.aVA = (TextView) findViewById(a.g.tv_tip);
        this.aEp.setScaleType(ImageView.ScaleType.FIT_XY);
        this.aEp.setIsRound(true);
        this.aEp.setAutoChangeStyle(false);
        this.aEp.setDefaultBgResource(a.f.sdk_default_avatar);
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
