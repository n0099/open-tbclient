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
    private AlphaGradientHListView bze;
    private ImageView bzf;
    private a bzg;
    private a.InterfaceC0187a bzh;

    public QuickImInputHeaderView(Context context) {
        super(context);
        init();
    }

    @Override // com.baidu.live.im.d.a
    public void setCallback(a.InterfaceC0187a interfaceC0187a) {
        this.bzh = interfaceC0187a;
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
        if (this.bzg == null) {
            this.bzg = new a();
            this.bzg.setData(list);
            this.bze.setAdapter((ListAdapter) this.bzg);
        } else {
            this.bzg.setData(list);
            this.bzg.notifyDataSetChanged();
        }
        this.bze.setSelection(0);
    }

    @Override // com.baidu.live.im.d.a
    public void setInVisible() {
        this.bzf.setVisibility(8);
    }

    @Override // com.baidu.live.im.d.a
    public AlphaGradientHListView getListView() {
        return this.bze;
    }

    @Override // com.baidu.live.im.d.a
    public void setTextColor(int i) {
        this.bzg.setTextColor(i);
        this.bzg.notifyDataSetChanged();
    }

    private void init() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.g.ala_quick_im_input_header, (ViewGroup) this, true);
        this.bze = (AlphaGradientHListView) findViewById(a.f.lv);
        this.bze.setShadowWidth(getResources().getDimensionPixelOffset(a.d.sdk_ds56));
        this.bze.setNeedAlphaShade(true);
        this.bze.setColor(getResources().getColor(a.c.sdk_white_alpha100), getResources().getColor(a.c.sdk_white_alpha0));
        this.bze.setSelector(getResources().getDrawable(a.e.sdk_transparent_bg));
        this.bze.setOnItemClickListener(new AdapterView.c() { // from class: com.baidu.live.quick.QuickImInputHeaderView.1
            @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
            public void a(AdapterView<?> adapterView, View view, int i, long j) {
                if (QuickImInputHeaderView.this.bzh != null) {
                    QuickImInputHeaderView.this.bzh.G(QuickImInputHeaderView.this.bzg.getItem(i), i);
                }
            }
        });
        this.bzf = (ImageView) findViewById(a.f.iv_more);
        this.bzf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.quick.QuickImInputHeaderView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (QuickImInputHeaderView.this.bzh != null) {
                    QuickImInputHeaderView.this.bzh.Ob();
                }
            }
        });
    }

    /* loaded from: classes11.dex */
    private static class a extends BaseAdapter {
        private List<String> bzj;
        private int textColor;

        private a() {
            this.textColor = 0;
        }

        public void setTextColor(int i) {
            this.textColor = i;
        }

        public void setData(List<String> list) {
            if (this.bzj == null) {
                this.bzj = new ArrayList();
            }
            this.bzj.clear();
            if (list != null) {
                this.bzj.addAll(list);
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.bzj != null) {
                return this.bzj.size();
            }
            return 0;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        public String getItem(int i) {
            return (this.bzj == null || getCount() <= i) ? "" : this.bzj.get(i);
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
                bVar2.textView = (TextView) view.findViewById(a.f.f2566tv);
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
