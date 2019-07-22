package com.baidu.swan.apps.core.d;

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
import com.baidu.swan.apps.res.widget.dialog.g;
import com.baidu.swan.apps.setting.oauth.a.b;
import com.baidu.swan.support.v4.app.FragmentActivity;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class f extends b implements AdapterView.OnItemClickListener {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static String arG = "pref_close_scope_alert_showed";
    private BaseAdapter arH;
    private FrameLayout arI;
    private final List<com.baidu.swan.apps.setting.oauth.e> mList = new ArrayList();
    private boolean arJ = false;

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
        O(inflate);
        this.arI = (FrameLayout) inflate.findViewById(a.f.container);
        this.arH = AG();
        ListView listView = (ListView) inflate.findViewById(a.f.ai_apps_setting_list);
        listView.setAdapter((ListAdapter) this.arH);
        listView.setOnItemClickListener(this);
        return a(zJ() ? S(inflate) : inflate, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public void O(View view) {
        R(view);
        cb(-1);
        cc(ViewCompat.MEASURED_STATE_MASK);
        dK(getString(a.h.common_menu_authority_management));
        bd(true);
        setRightZoneVisibility(false);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        initData();
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void zv() {
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected boolean xD() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        setRequestedOrientation(1);
        if (DEBUG) {
            Log.d("SwanAppSettingFragment", "onResume()");
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (!this.arJ) {
            this.arJ = true;
            com.baidu.swan.apps.setting.oauth.e eVar = this.mList.get(i);
            if (!eVar.Nu() || AE().Mh().getBoolean(arG, false)) {
                com.baidu.swan.apps.setting.oauth.c.a("onItemClick : " + eVar, (Boolean) false);
                b(eVar);
                return;
            }
            a(eVar);
        }
    }

    private void a(final com.baidu.swan.apps.setting.oauth.e eVar) {
        new g.a(Xc()).cm(a.h.aiapps_setting_scope_close_alert_title).cl(a.h.aiapps_setting_scope_close_alert_msg).a(new com.baidu.swan.apps.view.b.a()).b(a.h.aiapps_setting_scope_close_alert_btn_pos, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.f.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                f.this.AE().Mh().putBoolean(f.arG, true);
                f.this.b(eVar);
            }
        }).c(a.h.aiapps_cancel, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.f.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                f.this.arJ = false;
            }
        }).ce(true).a(new DialogInterface.OnCancelListener() { // from class: com.baidu.swan.apps.core.d.f.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                f.this.arJ = false;
            }
        }).Lx();
    }

    private void initData() {
        com.baidu.swan.apps.res.widget.loadingview.a.d(Xc(), this.arI);
        com.baidu.swan.apps.network.c.b.a.e(new com.baidu.swan.apps.an.d.a<Map<String, com.baidu.swan.apps.setting.oauth.e>>() { // from class: com.baidu.swan.apps.core.d.f.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.an.d.a
            /* renamed from: m */
            public void D(Map<String, com.baidu.swan.apps.setting.oauth.e> map) {
                if (f.this.Xc() != null) {
                    com.baidu.swan.apps.res.widget.loadingview.a.h(f.this.arI);
                    if (map != null) {
                        f.this.mList.clear();
                        for (Map.Entry<String, com.baidu.swan.apps.setting.oauth.e> entry : map.entrySet()) {
                            com.baidu.swan.apps.setting.oauth.e value = entry.getValue();
                            if (!TextUtils.isEmpty(entry.getKey()) && value != null && !value.forbidden && value.Nv() && "2".equals(value.grade) && !"snsapi_base".equals(value.id)) {
                                f.this.mList.add(value);
                            }
                        }
                        f.this.AF();
                        f.this.arH.notifyDataSetChanged();
                    }
                }
            }
        });
    }

    @Nullable
    public com.baidu.swan.apps.ae.b AE() {
        return com.baidu.swan.apps.w.e.GF().AE();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AF() {
        boolean isEmpty = this.mList.isEmpty();
        TextView textView = (TextView) getView().findViewById(a.f.tips);
        textView.setVisibility(isEmpty ? 8 : 0);
        if (!isEmpty) {
            textView.setText(getString(a.h.aiapps_setting_tips, AE().getName()));
        }
        View findViewById = getView().findViewById(a.f.id_empty_container);
        if (findViewById != null) {
            findViewById.setVisibility(isEmpty ? 0 : 8);
        }
        TextView textView2 = (TextView) getView().findViewById(a.f.empty);
        if (isEmpty) {
            textView2.setText(getString(a.h.aiapps_setting_empty, AE().getName()));
        }
    }

    private BaseAdapter AG() {
        return new BaseAdapter() { // from class: com.baidu.swan.apps.core.d.f.5
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
                    aVar.arM = (CheckBox) view.findViewById(a.f.checkbox);
                    aVar.title = (TextView) view.findViewById(a.f.title);
                    view.setTag(aVar);
                }
                a aVar2 = (a) view.getTag();
                com.baidu.swan.apps.setting.oauth.e item = getItem(i);
                String str = TextUtils.isEmpty(item.aUP) ? item.name : item.aUP;
                TextView textView = aVar2.title;
                if (TextUtils.isEmpty(str)) {
                    str = "";
                }
                textView.setText(str);
                aVar2.arM.setChecked(item.Nu());
                return view;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.swan.apps.setting.oauth.e eVar) {
        b(eVar, !eVar.Nu());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.setting.oauth.e eVar, boolean z) {
        eVar.aUS = z ? 1 : -1;
        this.arH.notifyDataSetChanged();
    }

    private void b(final com.baidu.swan.apps.setting.oauth.e eVar, boolean z) {
        com.baidu.swan.apps.ae.b AE = AE();
        if (AE == null) {
            this.arJ = false;
            return;
        }
        com.baidu.swan.apps.res.widget.loadingview.a.d(Xc(), this.arI);
        AE.Mh().a(Xc(), eVar.id, z, true, new com.baidu.swan.apps.an.d.a<com.baidu.swan.apps.setting.oauth.g<b.d>>() { // from class: com.baidu.swan.apps.core.d.f.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.an.d.a
            /* renamed from: a */
            public void D(com.baidu.swan.apps.setting.oauth.g<b.d> gVar) {
                FragmentActivity Xc = f.this.Xc();
                if (Xc != null) {
                    com.baidu.swan.apps.res.widget.loadingview.a.h(f.this.arI);
                    if (gVar != null && gVar.isOk()) {
                        f.this.a(eVar, gVar.mData.aUW);
                    } else {
                        com.baidu.swan.apps.res.widget.b.d.k(Xc, a.h.aiapps_setting_scope_auth_failed).LQ();
                    }
                    f.this.arJ = false;
                }
            }
        });
    }

    /* loaded from: classes2.dex */
    class a {
        CheckBox arM;
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

    @Override // com.baidu.swan.apps.core.d.b, com.baidu.swan.support.v4.app.Fragment
    public void onDetach() {
        this.mActivity = null;
        super.onDetach();
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.baidu.swan.apps.ae.b AE = AE();
        if (AE != null) {
            AE.Mh().Nj();
        }
        if (DEBUG) {
            Log.d("SwanAppSettingFragment", "onDestroy() obj: " + this);
        }
    }

    public static f AH() {
        return new f();
    }

    @Override // com.baidu.swan.apps.core.d.b, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable() {
        return true;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean zw() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean xp() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void zu() {
    }
}
