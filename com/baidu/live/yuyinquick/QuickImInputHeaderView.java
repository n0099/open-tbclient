package com.baidu.live.yuyinquick;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
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
/* loaded from: classes10.dex */
public class QuickImInputHeaderView extends RelativeLayout implements com.baidu.live.im.d.a {
    private a bZW;
    private AlphaGradientHListView bus;
    private a.InterfaceC0178a buv;

    public QuickImInputHeaderView(Context context) {
        super(context);
        init();
    }

    @Override // com.baidu.live.im.d.a
    public void setCallback(a.InterfaceC0178a interfaceC0178a) {
        this.buv = interfaceC0178a;
    }

    @Override // com.baidu.live.im.d.a
    @NonNull
    public View getView() {
        return this;
    }

    @Override // com.baidu.live.im.d.a
    public AlphaGradientHListView getListView() {
        return this.bus;
    }

    @Override // com.baidu.live.im.d.a
    public void setTextColor(int i) {
    }

    @Override // com.baidu.live.im.d.a
    public void setData(List<String> list) {
        if (this.bZW == null) {
            this.bZW = new a();
            this.bZW.setData(list);
            this.bus.setAdapter((ListAdapter) this.bZW);
        } else {
            this.bZW.setData(list);
            this.bZW.notifyDataSetChanged();
        }
        this.bus.setSelection(0);
    }

    @Override // com.baidu.live.im.d.a
    public void setInVisible() {
    }

    private void init() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.g.ala_quick_im_input_header, (ViewGroup) this, true);
        this.bus = (AlphaGradientHListView) findViewById(a.f.lv);
        this.bus.setShadowWidth(getResources().getDimensionPixelOffset(a.d.sdk_ds56));
        this.bus.setNeedAlphaShade(true);
        this.bus.setColor(getResources().getColor(a.c.sdk_white_alpha100), getResources().getColor(a.c.sdk_white_alpha0));
        this.bus.setSelector(getResources().getDrawable(a.e.sdk_transparent_bg));
        this.bus.setOnItemClickListener(new AdapterView.c() { // from class: com.baidu.live.yuyinquick.QuickImInputHeaderView.1
            @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
            public void a(AdapterView<?> adapterView, View view, int i, long j) {
                if (QuickImInputHeaderView.this.buv != null) {
                    QuickImInputHeaderView.this.buv.G(QuickImInputHeaderView.this.bZW.getItem(i), i);
                }
            }
        });
        findViewById(a.f.iv_more).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.yuyinquick.QuickImInputHeaderView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (QuickImInputHeaderView.this.buv != null) {
                    QuickImInputHeaderView.this.buv.Kg();
                }
            }
        });
    }

    /* loaded from: classes10.dex */
    private static class a extends BaseAdapter {
        private List<String> bux;

        private a() {
        }

        public void setData(List<String> list) {
            if (this.bux == null) {
                this.bux = new ArrayList();
            }
            this.bux.clear();
            if (list != null) {
                this.bux.addAll(list);
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.bux != null) {
                return this.bux.size();
            }
            return 0;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        public String getItem(int i) {
            return (this.bux == null || getCount() <= i) ? "" : this.bux.get(i);
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
                bVar2.textView = (TextView) view.findViewById(a.f.f2517tv);
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

    /* loaded from: classes10.dex */
    private static class b {
        TextView textView;

        private b() {
        }
    }
}
