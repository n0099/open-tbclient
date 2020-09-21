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
/* loaded from: classes3.dex */
public class b extends BaseAdapter {
    private Activity byQ;
    private ArrayList<com.baidu.swan.apps.media.chooser.model.a> cCr;
    private int cCs;
    private String cwD;

    public b(Activity activity, String str, ArrayList<com.baidu.swan.apps.media.chooser.model.a> arrayList) {
        this.byQ = activity;
        this.cwD = str;
        this.cCr = arrayList;
        this.cCs = (int) (ah.dip2px(this.byQ, 50.0f) / 2.0f);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cCr == null) {
            return 0;
        }
        return this.cCr.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i < 0 || i > this.cCr.size()) {
            return null;
        }
        return this.cCr.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.byQ).inflate(a.g.swanapp_album_name_item, (ViewGroup) null);
            a aVar2 = new a(view);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        view.setBackground(this.byQ.getResources().getDrawable(a.e.swanapp_album_name_item_selector));
        com.baidu.swan.apps.media.chooser.model.a aVar3 = this.cCr.get(i);
        if (aVar3 != null) {
            aVar.titleTv.setText(aVar3.iM());
            if (aVar3.cDi != null) {
                aVar.cCu.setText(iw(aVar3.cDi.size()));
                if (aVar3.cDi.get(0) != null && !TextUtils.isEmpty(aVar3.cDi.get(0).getPath())) {
                    ImageRequestBuilder ad = ImageRequestBuilder.ad(Uri.fromFile(new File(aVar3.cDi.get(0).getPath())));
                    ad.c(new d(this.cCs, this.cCs));
                    ad.yt(true);
                    aVar.cCt.setController(com.facebook.drawee.a.a.c.dTu().yf(false).bg(ad.eay()).c(aVar.cCt.getController()).dUl());
                }
            }
        }
        return view;
    }

    private String iw(int i) {
        return TextUtils.equals(this.cwD, "Image") ? this.byQ.getString(a.h.swanapp_image_pages, new Object[]{Integer.valueOf(i)}) : this.byQ.getString(a.h.swanapp_album_pages, new Object[]{Integer.valueOf(i)});
    }

    /* loaded from: classes3.dex */
    public class a {
        SimpleDraweeView cCt;
        TextView cCu;
        TextView titleTv;

        public a(View view) {
            this.cCt = (SimpleDraweeView) view.findViewById(a.f.album_name_item_img);
            this.titleTv = (TextView) view.findViewById(a.f.album_name_item_title);
            this.cCu = (TextView) view.findViewById(a.f.album_name_item_number);
        }
    }
}
