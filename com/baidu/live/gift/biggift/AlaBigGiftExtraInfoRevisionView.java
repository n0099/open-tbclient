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
    private HeadImageView aFf;
    private HeadImageView aWN;
    private FrameLayout aWO;
    private List<HeadImageView> aWP;
    private TextView aWQ;
    private Integer aWR;
    private TextView aWS;
    private AlphaAnimation aWT;
    private AlphaAnimation aWU;

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
        if (cVar.bbq != null && cVar.bbq.GV() == 1) {
            for (int i = 0; i < cVar.bbq.aWn.size(); i++) {
                if (cVar.bbq.aWn.get(i).portrait != null) {
                    arrayList.add(cVar.bbq.aWn.get(i).portrait);
                }
            }
        } else {
            arrayList.clear();
        }
        if (cVar.bbq != null && arrayList.size() != 0) {
            H(arrayList);
            this.aFf.startLoad(arrayList.get(0), 12, false);
            arrayList.remove(0);
            if (arrayList.size() < this.aWP.size()) {
                if (arrayList.size() != 0) {
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        this.aWP.get(i2).startLoad(arrayList.get(i2), 12, false);
                    }
                    int size = arrayList.size();
                    while (true) {
                        int i3 = size;
                        if (i3 >= this.aWP.size()) {
                            break;
                        }
                        this.aWP.get(i3).setVisibility(8);
                        size = i3 + 1;
                    }
                } else {
                    int size2 = arrayList.size();
                    while (true) {
                        int i4 = size2;
                        if (i4 >= this.aWP.size()) {
                            break;
                        }
                        this.aWP.get(i4).setVisibility(8);
                        size2 = i4 + 1;
                    }
                }
                if (cVar.bbq.GU() != null) {
                    this.aWQ.setText(cVar.bbq.GU());
                }
                if (cVar.bbq.GT() != null) {
                    this.aWS.setText(cVar.bbq.GT());
                    return;
                }
                return;
            }
            return;
        }
        if (cVar.portrait != null) {
            this.aFf.startLoad(cVar.portrait, 12, false);
            if (this.aWP != null) {
                for (int i5 = 0; i5 < this.aWP.size(); i5++) {
                    this.aWP.get(i5).setVisibility(8);
                }
            }
        }
        if (!TextUtils.isEmpty(cVar.userName)) {
            String str = cVar.userName;
            if (TextHelper.getTextLengthWithEmoji(str) > 20) {
                str = TextHelper.subStringWithEmoji(str, 20) + StringHelper.STRING_MORE;
            }
            this.aWQ.setText(str);
        }
        if (cVar.bbc != null) {
            this.aWS.setText(getResources().getString(a.h.donate) + cVar.bbc.FU());
        }
    }

    public void Hy() {
        setVisibility(0);
        if (this.aWT == null) {
            this.aWT = new AlphaAnimation(0.0f, 1.0f);
            this.aWT.setDuration(500L);
            this.aWT.setFillAfter(true);
        }
        startAnimation(this.aWT);
    }

    public void Hz() {
        if (this.aWU == null) {
            this.aWU = new AlphaAnimation(1.0f, 0.0f);
            this.aWU.setDuration(500L);
            this.aWU.setFillAfter(true);
        }
        startAnimation(this.aWU);
    }

    public void onDestroy() {
        setVisibility(8);
        clearAnimation();
        this.aWP.clear();
    }

    public void end() {
        setVisibility(8);
        clearAnimation();
    }

    private void init() {
        setBackgroundColor(0);
        this.aWP = new ArrayList(4);
        this.aWR = 3;
        HA();
    }

    private void HA() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.g.popup_extra_info_revision_layout, (ViewGroup) this, true);
        this.aFf = (HeadImageView) findViewById(a.f.iv_avatar);
        this.aWO = (FrameLayout) findViewById(a.f.content_frame);
        this.aWP = new ArrayList(3);
        this.aWR = 3;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.aFf.getLayoutParams();
        for (int i = 0; i < this.aWR.intValue(); i++) {
            this.aWN = new HeadImageView(getContext());
            this.aWN.setIsRound(true);
            this.aWN.setAutoChangeStyle(false);
            this.aWN.setDefaultBgResource(a.e.sdk_default_avatar);
            this.aWN.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.aWP.add(this.aWN);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams.width, layoutParams.height);
            layoutParams2.gravity = 5;
            layoutParams2.rightMargin = (layoutParams.width - 12) * (i + 1);
            this.aWO.addView(this.aWP.get(i), layoutParams2);
        }
        this.aWQ = (TextView) findViewById(a.f.tv_sender);
        this.aWS = (TextView) findViewById(a.f.tv_tip);
        this.aFf.setScaleType(ImageView.ScaleType.FIT_XY);
        this.aFf.setIsRound(true);
        this.aFf.setAutoChangeStyle(false);
        this.aFf.setDefaultBgResource(a.e.sdk_default_avatar);
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
