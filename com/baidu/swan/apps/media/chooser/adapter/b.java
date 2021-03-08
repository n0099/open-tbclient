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
import com.baidu.swan.apps.ao.ah;
import com.facebook.drawee.a.a.c;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.d;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class b extends BaseAdapter {
    private String dge;
    private ArrayList<com.baidu.swan.apps.media.chooser.model.a> dlX;
    private int dlY;
    private Activity mContext;

    public b(Activity activity, String str, ArrayList<com.baidu.swan.apps.media.chooser.model.a> arrayList) {
        this.mContext = activity;
        this.dge = str;
        this.dlX = arrayList;
        this.dlY = (int) (ah.dip2px(this.mContext, 50.0f) / 2.0f);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dlX == null) {
            return 0;
        }
        return this.dlX.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i < 0 || i > this.dlX.size()) {
            return null;
        }
        return this.dlX.get(i);
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
        com.baidu.swan.apps.media.chooser.model.a aVar3 = this.dlX.get(i);
        if (aVar3 != null) {
            aVar.titleTv.setText(aVar3.ik());
            if (aVar3.dmS != null) {
                aVar.dma.setText(ib(aVar3.dmS.size()));
                if (aVar3.dmS.get(0) != null && !TextUtils.isEmpty(aVar3.dmS.get(0).getPath())) {
                    ImageRequestBuilder ag = ImageRequestBuilder.ag(Uri.fromFile(new File(aVar3.dmS.get(0).getPath())));
                    ag.c(new d(this.dlY, this.dlY));
                    ag.Bw(true);
                    aVar.dlZ.setController(c.etF().Bk(false).bq(ag.eAz()).c(aVar.dlZ.getController()).euw());
                }
            }
        }
        return view;
    }

    private String ib(int i) {
        return TextUtils.equals(this.dge, "Image") ? this.mContext.getString(a.h.swanapp_image_pages, new Object[]{Integer.valueOf(i)}) : this.mContext.getString(a.h.swanapp_album_pages, new Object[]{Integer.valueOf(i)});
    }

    /* loaded from: classes8.dex */
    public class a {
        SimpleDraweeView dlZ;
        TextView dma;
        TextView titleTv;

        public a(View view) {
            this.dlZ = (SimpleDraweeView) view.findViewById(a.f.album_name_item_img);
            this.titleTv = (TextView) view.findViewById(a.f.album_name_item_title);
            this.dma = (TextView) view.findViewById(a.f.album_name_item_number);
        }
    }
}
