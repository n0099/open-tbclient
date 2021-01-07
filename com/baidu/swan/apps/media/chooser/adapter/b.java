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
/* loaded from: classes9.dex */
public class b extends BaseAdapter {
    private String dhe;
    private ArrayList<com.baidu.swan.apps.media.chooser.model.a> dmX;
    private int dmY;
    private Activity mContext;

    public b(Activity activity, String str, ArrayList<com.baidu.swan.apps.media.chooser.model.a> arrayList) {
        this.mContext = activity;
        this.dhe = str;
        this.dmX = arrayList;
        this.dmY = (int) (ah.dip2px(this.mContext, 50.0f) / 2.0f);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dmX == null) {
            return 0;
        }
        return this.dmX.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i < 0 || i > this.dmX.size()) {
            return null;
        }
        return this.dmX.get(i);
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
        com.baidu.swan.apps.media.chooser.model.a aVar3 = this.dmX.get(i);
        if (aVar3 != null) {
            aVar.titleTv.setText(aVar3.il());
            if (aVar3.dnT != null) {
                aVar.dna.setText(jD(aVar3.dnT.size()));
                if (aVar3.dnT.get(0) != null && !TextUtils.isEmpty(aVar3.dnT.get(0).getPath())) {
                    ImageRequestBuilder aj = ImageRequestBuilder.aj(Uri.fromFile(new File(aVar3.dnT.get(0).getPath())));
                    aj.c(new d(this.dmY, this.dmY));
                    aj.Bj(true);
                    aVar.dmZ.setController(c.euP().AX(false).bo(aj.eBI()).c(aVar.dmZ.getController()).evG());
                }
            }
        }
        return view;
    }

    private String jD(int i) {
        return TextUtils.equals(this.dhe, "Image") ? this.mContext.getString(a.h.swanapp_image_pages, new Object[]{Integer.valueOf(i)}) : this.mContext.getString(a.h.swanapp_album_pages, new Object[]{Integer.valueOf(i)});
    }

    /* loaded from: classes9.dex */
    public class a {
        SimpleDraweeView dmZ;
        TextView dna;
        TextView titleTv;

        public a(View view) {
            this.dmZ = (SimpleDraweeView) view.findViewById(a.f.album_name_item_img);
            this.titleTv = (TextView) view.findViewById(a.f.album_name_item_title);
            this.dna = (TextView) view.findViewById(a.f.album_name_item_number);
        }
    }
}
