package com.baidu.live.yuyinquick;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.im.d.a;
import com.baidu.live.sdk.a;
import com.baidu.live.tieba.horizonallist.widget.AdapterView;
import com.baidu.live.view.AlphaGradientHListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class QuickImInputHeaderView extends RelativeLayout implements com.baidu.live.im.d.a {
    private a bUw;
    private AlphaGradientHListView bqU;
    private a.InterfaceC0189a bqW;

    public QuickImInputHeaderView(Context context) {
        super(context);
        init();
    }

    @Override // com.baidu.live.im.d.a
    public void setCallback(a.InterfaceC0189a interfaceC0189a) {
        this.bqW = interfaceC0189a;
    }

    @Override // com.baidu.live.im.d.a
    @NonNull
    public View getView() {
        return this;
    }

    @Override // com.baidu.live.im.d.a
    public void setData(List<String> list) {
        if (this.bUw == null) {
            this.bUw = new a();
            this.bUw.setData(list);
            this.bqU.setAdapter((ListAdapter) this.bUw);
        } else {
            this.bUw.setData(list);
            this.bUw.notifyDataSetChanged();
        }
        this.bqU.setSelection(0);
    }

    private void init() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.g.ala_quick_im_input_header, (ViewGroup) this, true);
        this.bqU = (AlphaGradientHListView) findViewById(a.f.lv);
        this.bqU.setShadowWidth(getResources().getDimensionPixelOffset(a.d.sdk_ds56));
        this.bqU.setNeedAlphaShade(true);
        this.bqU.setColor(getResources().getColor(a.c.sdk_white_alpha100), getResources().getColor(a.c.sdk_white_alpha0));
        this.bqU.setSelector(getResources().getDrawable(a.e.sdk_transparent_bg));
        this.bqU.setOnItemClickListener(new AdapterView.c() { // from class: com.baidu.live.yuyinquick.QuickImInputHeaderView.1
            @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
            public void a(AdapterView<?> adapterView, View view, int i, long j) {
                if (QuickImInputHeaderView.this.bqW != null) {
                    QuickImInputHeaderView.this.bqW.C(QuickImInputHeaderView.this.bUw.getItem(i), i);
                }
            }
        });
        findViewById(a.f.iv_more).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.yuyinquick.QuickImInputHeaderView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (QuickImInputHeaderView.this.bqW != null) {
                    QuickImInputHeaderView.this.bqW.MJ();
                }
            }
        });
    }

    /* loaded from: classes4.dex */
    private static class a extends BaseAdapter {
        private List<String> bqY;

        private a() {
        }

        public void setData(List<String> list) {
            if (this.bqY == null) {
                this.bqY = new ArrayList();
            }
            this.bqY.clear();
            if (list != null) {
                this.bqY.addAll(list);
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.bqY != null) {
                return this.bqY.size();
            }
            return 0;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        public String getItem(int i) {
            return (this.bqY == null || getCount() <= i) ? "" : this.bqY.get(i);
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
                bVar2.textView = (TextView) view.findViewById(a.f.f1853tv);
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

    /* loaded from: classes4.dex */
    private static class b {
        TextView textView;

        private b() {
        }
    }
}
