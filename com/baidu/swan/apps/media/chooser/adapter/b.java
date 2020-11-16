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
import com.baidu.swan.apps.ap.ah;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.d;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class b extends BaseAdapter {
    private Activity bMo;
    private String cVo;
    private ArrayList<com.baidu.swan.apps.media.chooser.model.a> dbe;
    private int dbf;

    public b(Activity activity, String str, ArrayList<com.baidu.swan.apps.media.chooser.model.a> arrayList) {
        this.bMo = activity;
        this.cVo = str;
        this.dbe = arrayList;
        this.dbf = (int) (ah.dip2px(this.bMo, 50.0f) / 2.0f);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dbe == null) {
            return 0;
        }
        return this.dbe.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i < 0 || i > this.dbe.size()) {
            return null;
        }
        return this.dbe.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.bMo).inflate(a.g.swanapp_album_name_item, (ViewGroup) null);
            a aVar2 = new a(view);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        view.setBackground(this.bMo.getResources().getDrawable(a.e.swanapp_album_name_item_selector));
        com.baidu.swan.apps.media.chooser.model.a aVar3 = this.dbe.get(i);
        if (aVar3 != null) {
            aVar.titleTv.setText(aVar3.iN());
            if (aVar3.dbV != null) {
                aVar.dbh.setText(jk(aVar3.dbV.size()));
                if (aVar3.dbV.get(0) != null && !TextUtils.isEmpty(aVar3.dbV.get(0).getPath())) {
                    ImageRequestBuilder ae = ImageRequestBuilder.ae(Uri.fromFile(new File(aVar3.dbV.get(0).getPath())));
                    ae.c(new d(this.dbf, this.dbf));
                    ae.AA(true);
                    aVar.dbg.setController(com.facebook.drawee.a.a.c.ekQ().Am(false).bo(ae.erW()).c(aVar.dbg.getController()).elH());
                }
            }
        }
        return view;
    }

    private String jk(int i) {
        return TextUtils.equals(this.cVo, "Image") ? this.bMo.getString(a.h.swanapp_image_pages, new Object[]{Integer.valueOf(i)}) : this.bMo.getString(a.h.swanapp_album_pages, new Object[]{Integer.valueOf(i)});
    }

    /* loaded from: classes7.dex */
    public class a {
        SimpleDraweeView dbg;
        TextView dbh;
        TextView titleTv;

        public a(View view) {
            this.dbg = (SimpleDraweeView) view.findViewById(a.f.album_name_item_img);
            this.titleTv = (TextView) view.findViewById(a.f.album_name_item_title);
            this.dbh = (TextView) view.findViewById(a.f.album_name_item_number);
        }
    }
}
