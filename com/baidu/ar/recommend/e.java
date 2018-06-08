package com.baidu.ar.recommend;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import com.baidu.ar.bean.ARResource;
import com.baidu.ar.rotate.OrientationManager;
import com.baidu.ar.ui.rotateview.RotateViewUtils;
import java.util.List;
/* loaded from: classes3.dex */
public class e extends ArrayAdapter<ARResource> {
    private ARResource a;
    private ARResource b;

    public e(Context context, List<ARResource> list) {
        super(context, 0, list);
    }

    public void a(ARResource aRResource) {
        this.a = aRResource;
        notifyDataSetChanged();
    }

    public void b(ARResource aRResource) {
        this.b = aRResource;
        notifyDataSetChanged();
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View bVar = view == null ? new b(getContext()) : view;
        b bVar2 = (b) bVar;
        ARResource item = getItem(i);
        bVar2.a(item, item.equals(this.a), this.b != null);
        bVar2.setTag(item);
        RotateViewUtils.requestOrientation(bVar2, OrientationManager.getGlobalOrientation());
        return bVar;
    }
}
