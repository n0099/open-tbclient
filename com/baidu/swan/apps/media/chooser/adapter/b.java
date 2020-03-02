package com.baidu.swan.apps.media.chooser.adapter;

import android.app.Activity;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.as.af;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.d;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class b extends BaseAdapter {
    private String bCq;
    private ArrayList<com.baidu.swan.apps.media.chooser.model.a> bCr;
    private int bCs;
    private Activity mContext;

    public b(Activity activity, String str, ArrayList<com.baidu.swan.apps.media.chooser.model.a> arrayList) {
        this.mContext = activity;
        this.bCq = str;
        this.bCr = arrayList;
        this.bCs = (int) (af.dip2px(this.mContext, 50.0f) / 2.0f);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bCr == null) {
            return 0;
        }
        return this.bCr.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i < 0 || i > this.bCr.size()) {
            return null;
        }
        return this.bCr.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.g.swanapp_album_name_item, (ViewGroup) null);
            a aVar2 = new a(view);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        view.setBackground(this.mContext.getResources().getDrawable(a.e.swanapp_album_name_item_selector));
        com.baidu.swan.apps.media.chooser.model.a aVar3 = this.bCr.get(i);
        if (aVar3 != null) {
            aVar.titleTv.setText(aVar3.bx());
            if (aVar3.bDf != null) {
                aVar.bCu.setText(fq(aVar3.bDf.size()));
                if (aVar3.bDf.get(0) != null && !TextUtils.isEmpty(aVar3.bDf.get(0).getPath())) {
                    ImageRequestBuilder Y = ImageRequestBuilder.Y(Uri.fromFile(new File(aVar3.bDf.get(0).getPath())));
                    Y.c(new d(this.bCs, this.bCs));
                    Y.vw(true);
                    aVar.bCt.setController(com.facebook.drawee.a.a.c.dly().vh(false).bg(Y.dsC()).c(aVar.bCt.getController()).dmp());
                }
            }
        }
        return view;
    }

    private String fq(int i) {
        return TextUtils.equals(this.bCq, "Image") ? this.mContext.getString(a.h.swanapp_image_pages, new Object[]{Integer.valueOf(i)}) : this.mContext.getString(a.h.swanapp_album_pages, new Object[]{Integer.valueOf(i)});
    }

    /* loaded from: classes11.dex */
    public class a {
        SimpleDraweeView bCt;
        TextView bCu;
        TextView titleTv;

        public a(View view) {
            this.bCt = (SimpleDraweeView) view.findViewById(a.f.album_name_item_img);
            this.titleTv = (TextView) view.findViewById(a.f.album_name_item_title);
            this.bCu = (TextView) view.findViewById(a.f.album_name_item_number);
        }
    }
}
