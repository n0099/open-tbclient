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
    private HeadImageView aDr;
    private HeadImageView aYo;
    private FrameLayout aYp;
    private List<HeadImageView> aYq;
    private TextView aYr;
    private Integer aYs;
    private TextView aYt;
    private AlphaAnimation aYu;
    private AlphaAnimation aYv;

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
        if (cVar.bdc != null && cVar.bdc.EX() == 1) {
            for (int i = 0; i < cVar.bdc.aXG.size(); i++) {
                if (cVar.bdc.aXG.get(i).portrait != null) {
                    arrayList.add(cVar.bdc.aXG.get(i).portrait);
                }
            }
        } else {
            arrayList.clear();
        }
        if (cVar.bdc != null && arrayList.size() != 0) {
            I(arrayList);
            this.aDr.startLoad(arrayList.get(0), 12, false);
            arrayList.remove(0);
            if (arrayList.size() < this.aYq.size()) {
                if (arrayList.size() != 0) {
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        this.aYq.get(i2).startLoad(arrayList.get(i2), 12, false);
                    }
                    int size = arrayList.size();
                    while (true) {
                        int i3 = size;
                        if (i3 >= this.aYq.size()) {
                            break;
                        }
                        this.aYq.get(i3).setVisibility(8);
                        size = i3 + 1;
                    }
                } else {
                    int size2 = arrayList.size();
                    while (true) {
                        int i4 = size2;
                        if (i4 >= this.aYq.size()) {
                            break;
                        }
                        this.aYq.get(i4).setVisibility(8);
                        size2 = i4 + 1;
                    }
                }
                if (cVar.bdc.EW() != null) {
                    this.aYr.setText(cVar.bdc.EW());
                }
                if (cVar.bdc.EV() != null) {
                    this.aYt.setText(cVar.bdc.EV());
                }
                this.aYt.setTextColor(getContext().getResources().getColor(a.c.sdk_color_ffe918));
                this.aYt.setMaxEms(7);
                return;
            }
            return;
        }
        if (cVar.portrait != null) {
            this.aDr.startLoad(cVar.portrait, 12, false);
            if (this.aYq != null) {
                for (int i5 = 0; i5 < this.aYq.size(); i5++) {
                    this.aYq.get(i5).setVisibility(8);
                }
            }
        }
        if (!TextUtils.isEmpty(cVar.userName)) {
            String str = cVar.userName;
            if (TextHelper.getTextLengthWithEmoji(str) > 20) {
                str = TextHelper.subStringWithEmoji(str, 20) + StringHelper.STRING_MORE;
            }
            this.aYr.setText(str);
        }
        if (cVar.bcO != null) {
            if (TextUtils.isEmpty(cVar.bde)) {
                this.aYt.setText(getResources().getString(a.h.donate) + cVar.bcO.DS());
                this.aYt.setTextColor(getContext().getResources().getColor(a.c.sdk_white_alpha100));
                this.aYt.setMaxEms(7);
                return;
            }
            this.aYt.setText(cVar.bde + cVar.bcO.DS());
            this.aYt.setTextColor(getContext().getResources().getColor(a.c.sdk_color_ffe918));
            this.aYt.setMaxEms(cVar.bde.length() + 5);
        }
    }

    public void FD() {
        setVisibility(0);
        if (this.aYu == null) {
            this.aYu = new AlphaAnimation(0.0f, 1.0f);
            this.aYu.setDuration(500L);
            this.aYu.setFillAfter(true);
        }
        startAnimation(this.aYu);
    }

    public void FE() {
        if (this.aYv == null) {
            this.aYv = new AlphaAnimation(1.0f, 0.0f);
            this.aYv.setDuration(500L);
            this.aYv.setFillAfter(true);
        }
        startAnimation(this.aYv);
    }

    public void onDestroy() {
        setVisibility(8);
        clearAnimation();
        this.aYq.clear();
    }

    public void end() {
        setVisibility(8);
        clearAnimation();
    }

    private void init() {
        setBackgroundColor(0);
        this.aYq = new ArrayList(4);
        this.aYs = 3;
        FF();
    }

    private void FF() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.g.popup_extra_info_revision_layout, (ViewGroup) this, true);
        this.aDr = (HeadImageView) findViewById(a.f.iv_avatar);
        this.aYp = (FrameLayout) findViewById(a.f.content_frame);
        this.aYq = new ArrayList(3);
        this.aYs = 3;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.aDr.getLayoutParams();
        for (int i = 0; i < this.aYs.intValue(); i++) {
            this.aYo = new HeadImageView(getContext());
            this.aYo.setIsRound(true);
            this.aYo.setAutoChangeStyle(false);
            this.aYo.setDefaultBgResource(a.e.sdk_default_avatar);
            this.aYo.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.aYq.add(this.aYo);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams.width, layoutParams.height);
            layoutParams2.gravity = 5;
            layoutParams2.rightMargin = (layoutParams.width - 12) * (i + 1);
            this.aYp.addView(this.aYq.get(i), layoutParams2);
        }
        this.aYr = (TextView) findViewById(a.f.tv_sender);
        this.aYt = (TextView) findViewById(a.f.tv_tip);
        this.aDr.setScaleType(ImageView.ScaleType.FIT_XY);
        this.aDr.setIsRound(true);
        this.aDr.setAutoChangeStyle(false);
        this.aDr.setDefaultBgResource(a.e.sdk_default_avatar);
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
