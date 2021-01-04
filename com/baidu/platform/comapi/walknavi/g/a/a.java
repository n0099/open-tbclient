package com.baidu.platform.comapi.walknavi.g.a;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.baidu.mapapi.map.MapBaseIndoorMapInfo;
import com.baidu.platform.comapi.walknavi.a.b;
import com.baidu.platform.comapi.wnplatform.p.h;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes15.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private ViewGroup f4498a;

    /* renamed from: b  reason: collision with root package name */
    private LinearLayout f4499b;
    private View c;
    private ListView d;
    private View e;
    private View f;
    private Activity g;

    public a(ViewGroup viewGroup, Activity activity) {
        this.f4498a = viewGroup;
        this.g = activity;
    }

    public void a() {
        this.f4499b = (LinearLayout) this.f4498a.findViewById(R.dimen.abc_dialog_corner_radius_material);
        if (this.c == null) {
            this.c = com.baidu.platform.comapi.wnplatform.p.a.a.a(this.g, R.array.S_O_X003, null);
        }
        this.e = this.c.findViewById(R.dimen.abc_button_padding_vertical_material);
        this.f = this.c.findViewById(R.dimen.abc_config_prefDialogWidth);
        this.f4499b.addView(this.c);
        this.d = (ListView) this.c.findViewById(R.dimen.abc_cascading_menus_min_smallest_width);
    }

    public void b() {
        if (this.f4499b != null && com.baidu.platform.comapi.wnplatform.a.a().c()) {
            this.f4499b.setVisibility(8);
        }
    }

    public void c() {
        this.f4499b.setVisibility(8);
    }

    public void a(MapBaseIndoorMapInfo mapBaseIndoorMapInfo) {
        if (mapBaseIndoorMapInfo != null) {
            String id = mapBaseIndoorMapInfo.getID();
            String curFloor = mapBaseIndoorMapInfo.getCurFloor();
            this.f4499b.setVisibility(0);
            ArrayList<String> floors = mapBaseIndoorMapInfo.getFloors();
            if (floors != null && floors.size() != 0) {
                this.d.setLayoutParams(a(floors, this.d, this.d.getLayoutParams()));
                b bVar = new b(floors);
                if (floors.size() > 3) {
                    bVar.a(true);
                    if (this.e != null) {
                        this.e.setVisibility(0);
                    }
                    if (this.f != null) {
                        this.f.setVisibility(0);
                    }
                } else {
                    bVar.a(false);
                    if (this.e != null) {
                        this.e.setVisibility(8);
                    }
                    if (this.f != null) {
                        this.f.setVisibility(8);
                    }
                }
                bVar.b(true);
                bVar.b(id);
                bVar.a(curFloor);
                this.d.setAdapter((ListAdapter) bVar);
                int a2 = bVar.a();
                if (a2 >= this.d.getLastVisiblePosition()) {
                    if (a2 + 2 >= bVar.getCount() - 1) {
                        a2 = bVar.getCount() - 1;
                    } else {
                        a2 += 2;
                    }
                } else if (a2 <= this.d.getFirstVisiblePosition()) {
                    a2 = a2 + (-2) <= 0 ? 0 : a2 - 2;
                }
                bVar.notifyDataSetChanged();
                this.d.setSelection(a2);
            }
        }
    }

    public void a(String str) {
        int i = 0;
        this.f4499b.setVisibility(0);
        b bVar = (b) this.d.getAdapter();
        if (bVar != null) {
            bVar.a(str);
            int a2 = bVar.a();
            if (a2 >= this.d.getLastVisiblePosition()) {
                if (a2 + 2 >= bVar.getCount() - 1) {
                    i = bVar.getCount() - 1;
                } else {
                    i = a2 + 2;
                }
            } else if (a2 > this.d.getFirstVisiblePosition()) {
                i = a2;
            } else if (a2 - 2 > 0) {
                i = a2 - 2;
            }
            bVar.notifyDataSetChanged();
            this.d.setSelection(i);
        }
    }

    private ViewGroup.LayoutParams a(List<String> list, View view, ViewGroup.LayoutParams layoutParams) {
        if (list != null) {
            if (list.size() > 5) {
                layoutParams.height = h.a(this.g, 185);
            } else {
                layoutParams.height = h.a(this.g, (list.size() * 37) - 2);
            }
        }
        return layoutParams;
    }
}
