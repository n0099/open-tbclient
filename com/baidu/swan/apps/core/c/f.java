package com.baidu.swan.apps.core.c;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.widget.dialog.e;
import com.baidu.swan.apps.setting.oauth.a.b;
import com.baidu.swan.support.v4.app.FragmentActivity;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class f extends b implements AdapterView.OnItemClickListener {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static String aqY = "pref_close_scope_alert_showed";
    private BaseAdapter aqZ;
    private FrameLayout ara;
    private final List<com.baidu.swan.apps.setting.oauth.e> mList = new ArrayList();
    private boolean arb = false;

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (DEBUG) {
            Log.d("SwanAppSettingFragment", "onCreate() obj: " + this);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (DEBUG) {
            Log.d("SwanAppSettingFragment", "onAttach() obj: " + this);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.aiapps_setting_fragment, viewGroup, false);
        M(inflate);
        this.aqb.setRightImgZone2Visibility(8);
        this.ara = (FrameLayout) inflate.findViewById(a.f.container);
        this.aqZ = zc();
        ListView listView = (ListView) inflate.findViewById(a.f.ai_apps_setting_list);
        listView.setAdapter((ListAdapter) this.aqZ);
        listView.setOnItemClickListener(this);
        return a(yi() ? Q(inflate) : inflate, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.c.b
    public void M(View view) {
        P(view);
        cb(-1);
        cc(ViewCompat.MEASURED_STATE_MASK);
        dT(getString(a.h.common_menu_authority_management));
        aW(true);
        setRightMenuVisibility(false);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        initData();
    }

    @Override // com.baidu.swan.apps.core.c.b
    protected void xW() {
    }

    @Override // com.baidu.swan.apps.core.c.b, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        setRequestedOrientation(1);
        if (DEBUG) {
            Log.d("SwanAppSettingFragment", "onResume()");
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (!this.arb) {
            this.arb = true;
            com.baidu.swan.apps.setting.oauth.e eVar = this.mList.get(i);
            if (!eVar.Kf() || za().IZ().getBoolean(aqY, false)) {
                com.baidu.swan.apps.setting.oauth.c.a("onItemClick : " + eVar, (Boolean) false);
                b(eVar);
                return;
            }
            a(eVar);
        }
    }

    private void a(final com.baidu.swan.apps.setting.oauth.e eVar) {
        new e.a(Sw()).cm(a.h.aiapps_setting_scope_close_alert_title).cl(a.h.aiapps_setting_scope_close_alert_msg).a(new com.baidu.swan.apps.view.b.a()).b(a.h.aiapps_setting_scope_close_alert_btn_pos, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.c.f.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                f.this.za().IZ().putBoolean(f.aqY, true);
                f.this.b(eVar);
            }
        }).c(a.h.aiapps_cancel, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.c.f.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                f.this.arb = false;
            }
        }).bR(true).a(new DialogInterface.OnCancelListener() { // from class: com.baidu.swan.apps.core.c.f.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                f.this.arb = false;
            }
        }).Is();
    }

    private void initData() {
        com.baidu.swan.apps.res.widget.loadingview.a.d(Sw(), this.ara);
        com.baidu.swan.apps.network.c.b.a.a(new com.baidu.swan.apps.an.c.a<Map<String, com.baidu.swan.apps.setting.oauth.e>>() { // from class: com.baidu.swan.apps.core.c.f.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.an.c.a
            /* renamed from: m */
            public void D(Map<String, com.baidu.swan.apps.setting.oauth.e> map) {
                if (f.this.Sw() != null) {
                    com.baidu.swan.apps.res.widget.loadingview.a.h(f.this.ara);
                    if (map != null) {
                        f.this.mList.clear();
                        for (Map.Entry<String, com.baidu.swan.apps.setting.oauth.e> entry : map.entrySet()) {
                            com.baidu.swan.apps.setting.oauth.e value = entry.getValue();
                            if (!TextUtils.isEmpty(entry.getKey()) && value != null && !value.forbidden && value.Kg() && "2".equals(value.grade) && !"snsapi_base".equals(value.id)) {
                                f.this.mList.add(value);
                            }
                        }
                        f.this.zb();
                        f.this.aqZ.notifyDataSetChanged();
                    }
                }
            }
        });
    }

    @Nullable
    public com.baidu.swan.apps.ae.b za() {
        return com.baidu.swan.apps.w.e.Ea().za();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zb() {
        boolean isEmpty = this.mList.isEmpty();
        TextView textView = (TextView) getView().findViewById(a.f.tips);
        textView.setVisibility(isEmpty ? 8 : 0);
        if (!isEmpty) {
            textView.setText(getString(a.h.aiapps_setting_tips, za().getName()));
        }
        TextView textView2 = (TextView) getView().findViewById(a.f.empty);
        textView2.setVisibility(isEmpty ? 0 : 8);
        if (isEmpty) {
            textView2.setText(getString(a.h.aiapps_setting_empty, za().getName()));
        }
    }

    private BaseAdapter zc() {
        return new BaseAdapter() { // from class: com.baidu.swan.apps.core.c.f.5
            @Override // android.widget.Adapter
            public int getCount() {
                return f.this.mList.size();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.widget.Adapter
            /* renamed from: ci */
            public com.baidu.swan.apps.setting.oauth.e getItem(int i) {
                return (com.baidu.swan.apps.setting.oauth.e) f.this.mList.get(i);
            }

            @Override // android.widget.Adapter
            public long getItemId(int i) {
                return getItem(i).hashCode();
            }

            @Override // android.widget.Adapter
            public View getView(int i, View view, ViewGroup viewGroup) {
                if (view == null || !(view.getTag() instanceof a)) {
                    view = View.inflate(f.this.getContext(), a.g.aiapps_setting_item, null);
                    a aVar = new a();
                    aVar.are = (CheckBox) view.findViewById(a.f.checkbox);
                    aVar.title = (TextView) view.findViewById(a.f.title);
                    view.setTag(aVar);
                }
                a aVar2 = (a) view.getTag();
                com.baidu.swan.apps.setting.oauth.e item = getItem(i);
                String str = TextUtils.isEmpty(item.aRr) ? item.name : item.aRr;
                TextView textView = aVar2.title;
                if (TextUtils.isEmpty(str)) {
                    str = "";
                }
                textView.setText(str);
                aVar2.are.setChecked(item.Kf());
                return view;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.swan.apps.setting.oauth.e eVar) {
        b(eVar, !eVar.Kf());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.setting.oauth.e eVar, boolean z) {
        eVar.aRt = z ? 1 : -1;
        this.aqZ.notifyDataSetChanged();
    }

    private void b(final com.baidu.swan.apps.setting.oauth.e eVar, boolean z) {
        com.baidu.swan.apps.ae.b za = za();
        if (za == null) {
            this.arb = false;
            return;
        }
        com.baidu.swan.apps.res.widget.loadingview.a.d(Sw(), this.ara);
        za.IZ().a(Sw(), eVar.id, z, true, new com.baidu.swan.apps.an.c.a<com.baidu.swan.apps.setting.oauth.g<b.d>>() { // from class: com.baidu.swan.apps.core.c.f.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.an.c.a
            /* renamed from: a */
            public void D(com.baidu.swan.apps.setting.oauth.g<b.d> gVar) {
                FragmentActivity Sw = f.this.Sw();
                if (Sw != null) {
                    com.baidu.swan.apps.res.widget.loadingview.a.h(f.this.ara);
                    if (gVar != null && gVar.isOk()) {
                        f.this.a(eVar, gVar.mData.aRx);
                    } else {
                        com.baidu.swan.apps.res.widget.b.d.l(Sw, a.h.aiapps_setting_scope_auth_failed).II();
                    }
                    f.this.arb = false;
                }
            }
        });
    }

    /* loaded from: classes2.dex */
    class a {
        CheckBox are;
        TextView title;

        a() {
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (DEBUG) {
            Log.d("SwanAppSettingFragment", "onPause()");
        }
    }

    @Override // com.baidu.swan.apps.core.c.b, com.baidu.swan.support.v4.app.Fragment
    public void onDetach() {
        this.mActivity = null;
        super.onDetach();
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.baidu.swan.apps.ae.b za = za();
        if (za != null) {
            za.IZ().JV();
        }
        if (DEBUG) {
            Log.d("SwanAppSettingFragment", "onDestroy() obj: " + this);
        }
    }

    public static f zd() {
        return new f();
    }

    @Override // com.baidu.swan.apps.core.c.b, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable() {
        return true;
    }

    @Override // com.baidu.swan.apps.core.c.b
    public boolean xX() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.c.b
    public boolean vX() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.c.b
    protected void xV() {
    }
}
