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
/* loaded from: classes25.dex */
public class b extends c implements AdapterView.OnItemClickListener {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static String cPc = "pref_close_scope_alert_showed";
    private FrameLayout bNl;
    private BaseAdapter cPd;
    private final List<com.baidu.swan.apps.setting.oauth.e> mList = new ArrayList();
    private boolean cPe = false;

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (DEBUG) {
            Log.d("SwanAppAuthoritySettingFragment", "onCreate() obj: " + this);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (DEBUG) {
            Log.d("SwanAppAuthoritySettingFragment", "onAttach() obj: " + this);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.aiapps_setting_fragment, viewGroup, false);
        at(inflate);
        this.bNl = (FrameLayout) inflate.findViewById(a.f.container);
        this.cPd = aqE();
        ListView listView = (ListView) inflate.findViewById(a.f.ai_apps_setting_list);
        listView.setAdapter((ListAdapter) this.cPd);
        listView.setOnItemClickListener(this);
        return enableSliding(immersionEnabled() ? initImmersion(inflate) : inflate, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public void at(View view) {
        av(view);
        iq(-1);
        ir(ViewCompat.MEASURED_STATE_MASK);
        nv(getString(a.h.common_menu_authority_management));
        fe(true);
        setRightZoneVisibility(false);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        initData();
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void aqp() {
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected boolean alC() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        setRequestedOrientation(1);
        if (DEBUG) {
            Log.d("SwanAppAuthoritySettingFragment", "onResume()");
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (!this.cPe) {
            com.baidu.swan.apps.setting.oauth.e eVar = this.mList.get(i);
            this.cPe = true;
            if (!eVar.aLR() || aqC().aKg().getBoolean(cPc, false)) {
                com.baidu.swan.apps.setting.oauth.c.c("onItemClick : " + eVar, false);
                b(eVar);
                return;
            }
            a(eVar);
        }
    }

    @UiThread
    private void a(@NonNull C0432b c0432b) {
        FragmentActivity bff = bff();
        if (bff == null) {
            this.cPe = false;
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("result", Integer.valueOf(!c0432b.aLR() ? 1 : -1));
        if (bff.getContentResolver().update(SwanAppSubscribeMsgProvider.CONTENT_URI, contentValues, "_id=?", new String[]{c0432b.id}) > 0) {
            c0432b.dDk = c0432b.aLR() ? -1 : 1;
            this.cPd.notifyDataSetChanged();
        }
        this.cPe = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @UiThread
    public void E(@NonNull Activity activity) {
        com.baidu.swan.apps.runtime.e aJV = com.baidu.swan.apps.runtime.e.aJV();
        if (aJV != null) {
            Cursor query = activity.getContentResolver().query(SwanAppSubscribeMsgProvider.CONTENT_URI, new String[]{IMConstants.MSG_ROW_ID, "title", "result"}, "appKey=?", new String[]{aJV.getAppKey()}, null);
            if (query != null) {
                if (query.getCount() > 0) {
                    while (query.moveToNext()) {
                        int i = query.getInt(query.getColumnIndex(IMConstants.MSG_ROW_ID));
                        String string = query.getString(query.getColumnIndex("title"));
                        int i2 = query.getInt(query.getColumnIndex("result"));
                        C0432b c0432b = new C0432b(String.valueOf(i));
                        c0432b.name = string;
                        c0432b.dDk = i2 == -1 ? -1 : 1;
                        this.mList.add(c0432b);
                    }
                    aqD();
                    this.cPd.notifyDataSetChanged();
                }
                com.baidu.swan.c.d.closeSafely(query);
            }
        }
    }

    private void a(final com.baidu.swan.apps.setting.oauth.e eVar) {
        new g.a(bff()).iz(a.h.aiapps_setting_scope_close_alert_title).iy(a.h.aiapps_setting_scope_close_alert_msg).a(new com.baidu.swan.apps.view.c.a()).c(a.h.aiapps_setting_scope_close_alert_btn_pos, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.b.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                b.this.aqC().aKg().putBoolean(b.cPc, true);
                b.this.b(eVar);
            }
        }).d(a.h.aiapps_cancel, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.b.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                b.this.cPe = false;
            }
        }).gJ(true).a(new DialogInterface.OnCancelListener() { // from class: com.baidu.swan.apps.core.d.b.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                b.this.cPe = false;
            }
        }).aJB();
    }

    private void initData() {
        com.baidu.swan.apps.res.widget.loadingview.a.showLoadingView(bff(), this.bNl);
        this.mList.clear();
        this.cPd.notifyDataSetChanged();
        com.baidu.swan.apps.network.c.b.a.s(new com.baidu.swan.apps.ap.e.b<Map<String, com.baidu.swan.apps.setting.oauth.e>>() { // from class: com.baidu.swan.apps.core.d.b.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: x */
            public void M(Map<String, com.baidu.swan.apps.setting.oauth.e> map) {
                FragmentActivity bff = b.this.bff();
                if (bff != null && !bff.isFinishing() && !bff.isDestroyed()) {
                    com.baidu.swan.apps.res.widget.loadingview.a.dismissLoadingView(b.this.bNl);
                    if (map == null) {
                        b.this.E(bff);
                        return;
                    }
                    for (Map.Entry<String, com.baidu.swan.apps.setting.oauth.e> entry : map.entrySet()) {
                        com.baidu.swan.apps.setting.oauth.e value = entry.getValue();
                        if (!TextUtils.isEmpty(entry.getKey()) && value != null && !value.forbidden && value.aLS() && "2".equals(value.grade) && !"snsapi_base".equals(value.id)) {
                            b.this.mList.add(value);
                        }
                    }
                    b.this.aqD();
                    b.this.cPd.notifyDataSetChanged();
                    b.this.E(bff);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.core.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public class C0432b extends com.baidu.swan.apps.setting.oauth.e {
        C0432b(String str) {
            super(str);
        }
    }

    @Nullable
    public com.baidu.swan.apps.runtime.e aqC() {
        return com.baidu.swan.apps.v.f.aCp().aqC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqD() {
        View view = getView();
        if (view != null) {
            boolean isEmpty = this.mList.isEmpty();
            TextView textView = (TextView) view.findViewById(a.f.tips);
            textView.setVisibility(isEmpty ? 8 : 0);
            if (!isEmpty) {
                textView.setText(getString(a.h.aiapps_setting_tips, aqC().getName()));
            }
            View findViewById = view.findViewById(a.f.id_empty_container);
            if (findViewById != null) {
                findViewById.setVisibility(isEmpty ? 0 : 8);
            }
            TextView textView2 = (TextView) view.findViewById(a.f.empty);
            if (isEmpty) {
                textView2.setText(getString(a.h.aiapps_setting_empty, aqC().getName()));
            }
        }
    }

    private BaseAdapter aqE() {
        return new BaseAdapter() { // from class: com.baidu.swan.apps.core.d.b.5
            @Override // android.widget.Adapter
            public int getCount() {
                return b.this.mList.size();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.widget.Adapter
            /* renamed from: ip */
            public com.baidu.swan.apps.setting.oauth.e getItem(int i) {
                return (com.baidu.swan.apps.setting.oauth.e) b.this.mList.get(i);
            }

            @Override // android.widget.Adapter
            public long getItemId(int i) {
                return getItem(i).hashCode();
            }

            @Override // android.widget.Adapter
            public View getView(int i, View view, ViewGroup viewGroup) {
                if (view == null || !(view.getTag() instanceof a)) {
                    view = View.inflate(b.this.getContext(), a.g.aiapps_setting_item, null);
                    a aVar = new a();
                    aVar.cPh = (CheckBox) view.findViewById(a.f.checkbox);
                    aVar.title = (TextView) view.findViewById(a.f.title);
                    view.setTag(aVar);
                }
                a aVar2 = (a) view.getTag();
                com.baidu.swan.apps.setting.oauth.e item = getItem(i);
                String str = TextUtils.isEmpty(item.dDh) ? item.name : item.dDh;
                TextView textView = aVar2.title;
                if (TextUtils.isEmpty(str)) {
                    str = "";
                }
                textView.setText(str);
                aVar2.cPh.setChecked(item.aLR());
                return view;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.swan.apps.setting.oauth.e eVar) {
        if (eVar instanceof C0432b) {
            a((C0432b) eVar);
        } else {
            b(eVar, !eVar.aLR());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.setting.oauth.e eVar, boolean z) {
        eVar.dDk = z ? 1 : -1;
        this.cPd.notifyDataSetChanged();
    }

    private void b(final com.baidu.swan.apps.setting.oauth.e eVar, boolean z) {
        com.baidu.swan.apps.runtime.e aqC = aqC();
        if (aqC == null) {
            this.cPe = false;
            return;
        }
        com.baidu.swan.apps.res.widget.loadingview.a.showLoadingView(bff(), this.bNl);
        aqC.aKg().a(bff(), eVar.id, false, z, true, new com.baidu.swan.apps.ap.e.b<com.baidu.swan.apps.setting.oauth.h<b.d>>() { // from class: com.baidu.swan.apps.core.d.b.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: a */
            public void M(com.baidu.swan.apps.setting.oauth.h<b.d> hVar) {
                FragmentActivity bff = b.this.bff();
                if (bff != null) {
                    com.baidu.swan.apps.res.widget.loadingview.a.dismissLoadingView(b.this.bNl);
                    if (hVar != null && hVar.isOk()) {
                        b.this.a(eVar, hVar.mData.dDg);
                    } else {
                        com.baidu.swan.apps.res.widget.b.d.t(bff, a.h.aiapps_setting_scope_auth_failed).showToast();
                    }
                    b.this.cPe = false;
                }
            }
        });
    }

    /* loaded from: classes25.dex */
    class a {
        CheckBox cPh;
        TextView title;

        a() {
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (DEBUG) {
            Log.d("SwanAppAuthoritySettingFragment", "onPause()");
        }
    }

    @Override // com.baidu.swan.apps.core.d.c, com.baidu.swan.support.v4.app.Fragment
    public void onDetach() {
        this.mActivity = null;
        super.onDetach();
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.baidu.swan.apps.runtime.e aqC = aqC();
        if (aqC != null) {
            aqC.aKg().aLE();
        }
        if (DEBUG) {
            Log.d("SwanAppAuthoritySettingFragment", "onDestroy() obj: " + this);
        }
    }

    public static b aqF() {
        return new b();
    }

    @Override // com.baidu.swan.apps.core.d.c, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        return true;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean aqq() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean alb() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void alI() {
    }
}
