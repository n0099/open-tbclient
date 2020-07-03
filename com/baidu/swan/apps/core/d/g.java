package com.baidu.swan.apps.core.d;

import android.app.Activity;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.database.subscribe.SwanAppSubscribeMsgProvider;
import com.baidu.swan.apps.res.widget.dialog.g;
import com.baidu.swan.apps.setting.oauth.a.b;
import com.baidu.swan.support.v4.app.FragmentActivity;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes11.dex */
public class g extends com.baidu.swan.apps.core.d.b implements AdapterView.OnItemClickListener {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static String caQ = "pref_close_scope_alert_showed";
    private BaseAdapter caR;
    private FrameLayout caS;
    private final List<com.baidu.swan.apps.setting.oauth.e> mList = new ArrayList();
    private boolean caT = false;

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
        ae(inflate);
        this.caS = (FrameLayout) inflate.findViewById(a.f.container);
        this.caR = aak();
        ListView listView = (ListView) inflate.findViewById(a.f.ai_apps_setting_list);
        listView.setAdapter((ListAdapter) this.caR);
        listView.setOnItemClickListener(this);
        return enableSliding(immersionEnabled() ? initImmersion(inflate) : inflate, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public void ae(View view) {
        ah(view);
        eU(-1);
        eV(ViewCompat.MEASURED_STATE_MASK);
        jq(getString(a.h.common_menu_authority_management));
        dH(true);
        setRightZoneVisibility(false);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        initData();
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void YV() {
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected boolean UE() {
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
        if (!this.caT) {
            com.baidu.swan.apps.setting.oauth.e eVar = this.mList.get(i);
            this.caT = true;
            if (!eVar.arE() || aai().apY().getBoolean(caQ, false)) {
                com.baidu.swan.apps.setting.oauth.c.c("onItemClick : " + eVar, false);
                b(eVar);
                return;
            }
            a(eVar);
        }
    }

    @UiThread
    private void a(@NonNull b bVar) {
        FragmentActivity aIB = aIB();
        if (aIB == null) {
            this.caT = false;
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("result", Integer.valueOf(!bVar.arE() ? 1 : -1));
        if (aIB.getContentResolver().update(SwanAppSubscribeMsgProvider.CONTENT_URI, contentValues, "_id=?", new String[]{bVar.id}) > 0) {
            bVar.cJe = bVar.arE() ? -1 : 1;
            this.caR.notifyDataSetChanged();
        }
        this.caT = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @UiThread
    public void D(@NonNull Activity activity) {
        com.baidu.swan.apps.runtime.e apN = com.baidu.swan.apps.runtime.e.apN();
        if (apN != null) {
            Cursor query = activity.getContentResolver().query(SwanAppSubscribeMsgProvider.CONTENT_URI, new String[]{IMConstants.MSG_ROW_ID, "title", "result"}, "appKey=?", new String[]{apN.getAppKey()}, null);
            if (query != null) {
                if (query.getCount() > 0) {
                    while (query.moveToNext()) {
                        int i = query.getInt(query.getColumnIndex(IMConstants.MSG_ROW_ID));
                        String string = query.getString(query.getColumnIndex("title"));
                        int i2 = query.getInt(query.getColumnIndex("result"));
                        b bVar = new b(String.valueOf(i));
                        bVar.name = string;
                        bVar.cJe = i2 == -1 ? -1 : 1;
                        this.mList.add(bVar);
                    }
                    aaj();
                    this.caR.notifyDataSetChanged();
                }
                com.baidu.swan.e.d.closeSafely(query);
            }
        }
    }

    private void a(final com.baidu.swan.apps.setting.oauth.e eVar) {
        new g.a(aIB()).fe(a.h.aiapps_setting_scope_close_alert_title).fd(a.h.aiapps_setting_scope_close_alert_msg).a(new com.baidu.swan.apps.view.c.a()).c(a.h.aiapps_setting_scope_close_alert_btn_pos, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.g.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                g.this.aai().apY().putBoolean(g.caQ, true);
                g.this.b(eVar);
            }
        }).d(a.h.aiapps_cancel, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.g.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                g.this.caT = false;
            }
        }).eY(true).a(new DialogInterface.OnCancelListener() { // from class: com.baidu.swan.apps.core.d.g.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                g.this.caT = false;
            }
        }).apu();
    }

    private void initData() {
        com.baidu.swan.apps.res.widget.loadingview.a.showLoadingView(aIB(), this.caS);
        this.mList.clear();
        this.caR.notifyDataSetChanged();
        com.baidu.swan.apps.network.c.b.a.k(new com.baidu.swan.apps.aq.e.b<Map<String, com.baidu.swan.apps.setting.oauth.e>>() { // from class: com.baidu.swan.apps.core.d.g.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.aq.e.b
            /* renamed from: n */
            public void H(Map<String, com.baidu.swan.apps.setting.oauth.e> map) {
                FragmentActivity aIB = g.this.aIB();
                if (aIB != null && !aIB.isFinishing() && !aIB.isDestroyed()) {
                    com.baidu.swan.apps.res.widget.loadingview.a.dismissLoadingView(g.this.caS);
                    if (map == null) {
                        g.this.D(aIB);
                        return;
                    }
                    for (Map.Entry<String, com.baidu.swan.apps.setting.oauth.e> entry : map.entrySet()) {
                        com.baidu.swan.apps.setting.oauth.e value = entry.getValue();
                        if (!TextUtils.isEmpty(entry.getKey()) && value != null && !value.forbidden && value.arF() && "2".equals(value.grade) && !"snsapi_base".equals(value.id)) {
                            g.this.mList.add(value);
                        }
                    }
                    g.this.aaj();
                    g.this.caR.notifyDataSetChanged();
                    g.this.D(aIB);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class b extends com.baidu.swan.apps.setting.oauth.e {
        b(String str) {
            super(str);
        }
    }

    @Nullable
    public com.baidu.swan.apps.runtime.e aai() {
        return com.baidu.swan.apps.w.f.ajb().aai();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaj() {
        View view = getView();
        if (view != null) {
            boolean isEmpty = this.mList.isEmpty();
            TextView textView = (TextView) view.findViewById(a.f.tips);
            textView.setVisibility(isEmpty ? 8 : 0);
            if (!isEmpty) {
                textView.setText(getString(a.h.aiapps_setting_tips, aai().getName()));
            }
            View findViewById = view.findViewById(a.f.id_empty_container);
            if (findViewById != null) {
                findViewById.setVisibility(isEmpty ? 0 : 8);
            }
            TextView textView2 = (TextView) view.findViewById(a.f.empty);
            if (isEmpty) {
                textView2.setText(getString(a.h.aiapps_setting_empty, aai().getName()));
            }
        }
    }

    private BaseAdapter aak() {
        return new BaseAdapter() { // from class: com.baidu.swan.apps.core.d.g.5
            @Override // android.widget.Adapter
            public int getCount() {
                return g.this.mList.size();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.widget.Adapter
            /* renamed from: fa */
            public com.baidu.swan.apps.setting.oauth.e getItem(int i) {
                return (com.baidu.swan.apps.setting.oauth.e) g.this.mList.get(i);
            }

            @Override // android.widget.Adapter
            public long getItemId(int i) {
                return getItem(i).hashCode();
            }

            @Override // android.widget.Adapter
            public View getView(int i, View view, ViewGroup viewGroup) {
                if (view == null || !(view.getTag() instanceof a)) {
                    view = View.inflate(g.this.getContext(), a.g.aiapps_setting_item, null);
                    a aVar = new a();
                    aVar.caW = (CheckBox) view.findViewById(a.f.checkbox);
                    aVar.title = (TextView) view.findViewById(a.f.title);
                    view.setTag(aVar);
                }
                a aVar2 = (a) view.getTag();
                com.baidu.swan.apps.setting.oauth.e item = getItem(i);
                String str = TextUtils.isEmpty(item.cJb) ? item.name : item.cJb;
                TextView textView = aVar2.title;
                if (TextUtils.isEmpty(str)) {
                    str = "";
                }
                textView.setText(str);
                aVar2.caW.setChecked(item.arE());
                return view;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.swan.apps.setting.oauth.e eVar) {
        if (eVar instanceof b) {
            a((b) eVar);
        } else {
            b(eVar, !eVar.arE());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.setting.oauth.e eVar, boolean z) {
        eVar.cJe = z ? 1 : -1;
        this.caR.notifyDataSetChanged();
    }

    private void b(final com.baidu.swan.apps.setting.oauth.e eVar, boolean z) {
        com.baidu.swan.apps.runtime.e aai = aai();
        if (aai == null) {
            this.caT = false;
            return;
        }
        com.baidu.swan.apps.res.widget.loadingview.a.showLoadingView(aIB(), this.caS);
        aai.apY().a(aIB(), eVar.id, false, z, true, new com.baidu.swan.apps.aq.e.b<com.baidu.swan.apps.setting.oauth.h<b.d>>() { // from class: com.baidu.swan.apps.core.d.g.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.aq.e.b
            /* renamed from: a */
            public void H(com.baidu.swan.apps.setting.oauth.h<b.d> hVar) {
                FragmentActivity aIB = g.this.aIB();
                if (aIB != null) {
                    com.baidu.swan.apps.res.widget.loadingview.a.dismissLoadingView(g.this.caS);
                    if (hVar != null && hVar.isOk()) {
                        g.this.a(eVar, hVar.mData.cJa);
                    } else {
                        com.baidu.swan.apps.res.widget.b.d.k(aIB, a.h.aiapps_setting_scope_auth_failed).showToast();
                    }
                    g.this.caT = false;
                }
            }
        });
    }

    /* loaded from: classes11.dex */
    class a {
        CheckBox caW;
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
        com.baidu.swan.apps.runtime.e aai = aai();
        if (aai != null) {
            aai.apY().arr();
        }
        if (DEBUG) {
            Log.d("SwanAppSettingFragment", "onDestroy() obj: " + this);
        }
    }

    public static g aal() {
        return new g();
    }

    @Override // com.baidu.swan.apps.core.d.b, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        return true;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean YW() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean Ui() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void UI() {
    }
}
