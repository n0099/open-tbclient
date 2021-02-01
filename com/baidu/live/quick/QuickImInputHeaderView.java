package com.baidu.live.quick;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.live.im.d.a;
import com.baidu.live.sdk.a;
import com.baidu.live.tieba.horizonallist.widget.AdapterView;
import com.baidu.live.view.AlphaGradientHListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class QuickImInputHeaderView extends RelativeLayout implements com.baidu.live.im.d.a {
    private AlphaGradientHListView bxP;
    private ImageView bxQ;
    private a bxR;
    private a.InterfaceC0180a bxS;

    public QuickImInputHeaderView(Context context) {
        super(context);
        init();
    }

    @Override // com.baidu.live.im.d.a
    public void setCallback(a.InterfaceC0180a interfaceC0180a) {
        this.bxS = interfaceC0180a;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    @Override // com.baidu.live.im.d.a
    @NonNull
    public View getView() {
        return this;
    }

    @Override // com.baidu.live.im.d.a
    public void setData(List<String> list) {
        if (this.bxR == null) {
            this.bxR = new a();
            this.bxR.setData(list);
            this.bxP.setAdapter((ListAdapter) this.bxR);
        } else {
            this.bxR.setData(list);
            this.bxR.notifyDataSetChanged();
        }
        this.bxP.setSelection(0);
    }

    @Override // com.baidu.live.im.d.a
    public void setInVisible() {
        this.bxQ.setVisibility(8);
    }

    @Override // com.baidu.live.im.d.a
    public AlphaGradientHListView getListView() {
        return this.bxP;
    }

    @Override // com.baidu.live.im.d.a
    public void setTextColor(int i) {
        this.bxR.setTextColor(i);
        this.bxR.notifyDataSetChanged();
    }

    private void init() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.g.ala_quick_im_input_header, (ViewGroup) this, true);
        this.bxP = (AlphaGradientHListView) findViewById(a.f.lv);
        this.bxP.setShadowWidth(getResources().getDimensionPixelOffset(a.d.sdk_ds56));
        this.bxP.setNeedAlphaShade(true);
        this.bxP.setColor(getResources().getColor(a.c.sdk_white_alpha100), getResources().getColor(a.c.sdk_white_alpha0));
        this.bxP.setSelector(getResources().getDrawable(a.e.sdk_transparent_bg));
        this.bxP.setOnItemClickListener(new AdapterView.c() { // from class: com.baidu.live.quick.QuickImInputHeaderView.1
            @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
            public void a(AdapterView<?> adapterView, View view, int i, long j) {
                if (QuickImInputHeaderView.this.bxS != null) {
                    QuickImInputHeaderView.this.bxS.H(QuickImInputHeaderView.this.bxR.getItem(i), i);
                }
            }
        });
        this.bxQ = (ImageView) findViewById(a.f.iv_more);
        this.bxQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.quick.QuickImInputHeaderView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (QuickImInputHeaderView.this.bxS != null) {
                    QuickImInputHeaderView.this.bxS.LF();
                }
            }
        });
    }

    /* loaded from: classes11.dex */
    private static class a extends BaseAdapter {
        private List<String> bxU;
        private int textColor;

        private a() {
            this.textColor = 0;
        }

        public void setTextColor(int i) {
            this.textColor = i;
        }

        public void setData(List<String> list) {
            if (this.bxU == null) {
                this.bxU = new ArrayList();
            }
            this.bxU.clear();
            if (list != null) {
                this.bxU.addAll(list);
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.bxU != null) {
                return this.bxU.size();
            }
            return 0;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        public String getItem(int i) {
            return (this.bxU == null || getCount() <= i) ? "" : this.bxU.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(a.g.ala_quick_im_input_header_item, (ViewGroup) null);
                b bVar2 = new b();
                bVar2.textView = (TextView) view.findViewById(a.f.f2515tv);
                if (this.textColor != 0) {
                    bVar2.textView.setTextColor(this.textColor);
                    bVar2.textView.setBackgroundDrawable(viewGroup.getContext().getResources().getDrawable(a.e.sdk_im_round_quick_bg));
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) bVar2.textView.getLayoutParams();
                    layoutParams.height = viewGroup.getContext().getResources().getDimensionPixelSize(a.d.sdk_ds64);
                    layoutParams.gravity = 16;
                    bVar2.textView.setLayoutParams(layoutParams);
                }
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            bVar.textView.setText(getItem(i));
            ((FrameLayout.LayoutParams) bVar.textView.getLayoutParams()).rightMargin = viewGroup.getResources().getDimensionPixelOffset(i == getCount() + (-1) ? a.d.sdk_ds48 : a.d.sdk_ds16);
            return view;
        }
    }

    /* loaded from: classes11.dex */
    private static class b {
        TextView textView;

        private b() {
        }
    }
}
