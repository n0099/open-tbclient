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
/* loaded from: classes25.dex */
public class b extends BaseAdapter {
    private Activity beD;
    private String dck;
    private ArrayList<com.baidu.swan.apps.media.chooser.model.a> dic;
    private int die;

    public b(Activity activity, String str, ArrayList<com.baidu.swan.apps.media.chooser.model.a> arrayList) {
        this.beD = activity;
        this.dck = str;
        this.dic = arrayList;
        this.die = (int) (ah.dip2px(this.beD, 50.0f) / 2.0f);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dic == null) {
            return 0;
        }
        return this.dic.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i < 0 || i > this.dic.size()) {
            return null;
        }
        return this.dic.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.beD).inflate(a.g.swanapp_album_name_item, (ViewGroup) null);
            a aVar2 = new a(view);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        view.setBackground(this.beD.getResources().getDrawable(a.e.swanapp_album_name_item_selector));
        com.baidu.swan.apps.media.chooser.model.a aVar3 = this.dic.get(i);
        if (aVar3 != null) {
            aVar.titleTv.setText(aVar3.iN());
            if (aVar3.diW != null) {
                aVar.dig.setText(jI(aVar3.diW.size()));
                if (aVar3.diW.get(0) != null && !TextUtils.isEmpty(aVar3.diW.get(0).getPath())) {
                    ImageRequestBuilder af = ImageRequestBuilder.af(Uri.fromFile(new File(aVar3.diW.get(0).getPath())));
                    af.c(new d(this.die, this.die));
                    af.Bb(true);
                    aVar.dif.setController(com.facebook.drawee.a.a.c.eqF().AP(false).bo(af.exw()).c(aVar.dif.getController()).erw());
                }
            }
        }
        return view;
    }

    private String jI(int i) {
        return TextUtils.equals(this.dck, "Image") ? this.beD.getString(a.h.swanapp_image_pages, new Object[]{Integer.valueOf(i)}) : this.beD.getString(a.h.swanapp_album_pages, new Object[]{Integer.valueOf(i)});
    }

    /* loaded from: classes25.dex */
    public class a {
        SimpleDraweeView dif;
        TextView dig;
        TextView titleTv;

        public a(View view) {
            this.dif = (SimpleDraweeView) view.findViewById(a.f.album_name_item_img);
            this.titleTv = (TextView) view.findViewById(a.f.album_name_item_title);
            this.dig = (TextView) view.findViewById(a.f.album_name_item_number);
        }
    }
}
