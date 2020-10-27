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
/* loaded from: classes10.dex */
public class b extends c implements AdapterView.OnItemClickListener {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static String cEa = "pref_close_scope_alert_showed";
    private FrameLayout bEh;
    private BaseAdapter cEb;
    private final List<com.baidu.swan.apps.setting.oauth.e> mList = new ArrayList();
    private boolean cEc = false;

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
        an(inflate);
        this.bEh = (FrameLayout) inflate.findViewById(a.f.container);
        this.cEb = alE();
        ListView listView = (ListView) inflate.findViewById(a.f.ai_apps_setting_list);
        listView.setAdapter((ListAdapter) this.cEb);
        listView.setOnItemClickListener(this);
        return enableSliding(immersionEnabled() ? initImmersion(inflate) : inflate, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public void an(View view) {
        ap(view);
        hM(-1);
        hN(ViewCompat.MEASURED_STATE_MASK);
        mF(getString(a.h.common_menu_authority_management));
        eD(true);
        setRightZoneVisibility(false);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        initData();
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void alp() {
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected boolean agC() {
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
        if (!this.cEc) {
            com.baidu.swan.apps.setting.oauth.e eVar = this.mList.get(i);
            this.cEc = true;
            if (!eVar.aGR() || alC().aFg().getBoolean(cEa, false)) {
                com.baidu.swan.apps.setting.oauth.c.c("onItemClick : " + eVar, false);
                b(eVar);
                return;
            }
            a(eVar);
        }
    }

    @UiThread
    private void a(@NonNull C0410b c0410b) {
        FragmentActivity bah = bah();
        if (bah == null) {
            this.cEc = false;
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("result", Integer.valueOf(!c0410b.aGR() ? 1 : -1));
        if (bah.getContentResolver().update(SwanAppSubscribeMsgProvider.CONTENT_URI, contentValues, "_id=?", new String[]{c0410b.id}) > 0) {
            c0410b.drY = c0410b.aGR() ? -1 : 1;
            this.cEb.notifyDataSetChanged();
        }
        this.cEc = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @UiThread
    public void F(@NonNull Activity activity) {
        com.baidu.swan.apps.runtime.e aEV = com.baidu.swan.apps.runtime.e.aEV();
        if (aEV != null) {
            Cursor query = activity.getContentResolver().query(SwanAppSubscribeMsgProvider.CONTENT_URI, new String[]{IMConstants.MSG_ROW_ID, "title", "result"}, "appKey=?", new String[]{aEV.getAppKey()}, null);
            if (query != null) {
                if (query.getCount() > 0) {
                    while (query.moveToNext()) {
                        int i = query.getInt(query.getColumnIndex(IMConstants.MSG_ROW_ID));
                        String string = query.getString(query.getColumnIndex("title"));
                        int i2 = query.getInt(query.getColumnIndex("result"));
                        C0410b c0410b = new C0410b(String.valueOf(i));
                        c0410b.name = string;
                        c0410b.drY = i2 == -1 ? -1 : 1;
                        this.mList.add(c0410b);
                    }
                    alD();
                    this.cEb.notifyDataSetChanged();
                }
                com.baidu.swan.c.d.closeSafely(query);
            }
        }
    }

    private void a(final com.baidu.swan.apps.setting.oauth.e eVar) {
        new g.a(bah()).hV(a.h.aiapps_setting_scope_close_alert_title).hU(a.h.aiapps_setting_scope_close_alert_msg).a(new com.baidu.swan.apps.view.c.a()).c(a.h.aiapps_setting_scope_close_alert_btn_pos, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.b.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                b.this.alC().aFg().putBoolean(b.cEa, true);
                b.this.b(eVar);
            }
        }).d(a.h.aiapps_cancel, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.b.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                b.this.cEc = false;
            }
        }).gi(true).a(new DialogInterface.OnCancelListener() { // from class: com.baidu.swan.apps.core.d.b.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                b.this.cEc = false;
            }
        }).aEB();
    }

    private void initData() {
        com.baidu.swan.apps.res.widget.loadingview.a.showLoadingView(bah(), this.bEh);
        this.mList.clear();
        this.cEb.notifyDataSetChanged();
        com.baidu.swan.apps.network.c.b.a.s(new com.baidu.swan.apps.ap.e.b<Map<String, com.baidu.swan.apps.setting.oauth.e>>() { // from class: com.baidu.swan.apps.core.d.b.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: x */
            public void M(Map<String, com.baidu.swan.apps.setting.oauth.e> map) {
                FragmentActivity bah = b.this.bah();
                if (bah != null && !bah.isFinishing() && !bah.isDestroyed()) {
                    com.baidu.swan.apps.res.widget.loadingview.a.dismissLoadingView(b.this.bEh);
                    if (map == null) {
                        b.this.F(bah);
                        return;
                    }
                    for (Map.Entry<String, com.baidu.swan.apps.setting.oauth.e> entry : map.entrySet()) {
                        com.baidu.swan.apps.setting.oauth.e value = entry.getValue();
                        if (!TextUtils.isEmpty(entry.getKey()) && value != null && !value.forbidden && value.aGS() && "2".equals(value.grade) && !"snsapi_base".equals(value.id)) {
                            b.this.mList.add(value);
                        }
                    }
                    b.this.alD();
                    b.this.cEb.notifyDataSetChanged();
                    b.this.F(bah);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.core.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class C0410b extends com.baidu.swan.apps.setting.oauth.e {
        C0410b(String str) {
            super(str);
        }
    }

    @Nullable
    public com.baidu.swan.apps.runtime.e alC() {
        return com.baidu.swan.apps.v.f.axo().alC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alD() {
        View view = getView();
        if (view != null) {
            boolean isEmpty = this.mList.isEmpty();
            TextView textView = (TextView) view.findViewById(a.f.tips);
            textView.setVisibility(isEmpty ? 8 : 0);
            if (!isEmpty) {
                textView.setText(getString(a.h.aiapps_setting_tips, alC().getName()));
            }
            View findViewById = view.findViewById(a.f.id_empty_container);
            if (findViewById != null) {
                findViewById.setVisibility(isEmpty ? 0 : 8);
            }
            TextView textView2 = (TextView) view.findViewById(a.f.empty);
            if (isEmpty) {
                textView2.setText(getString(a.h.aiapps_setting_empty, alC().getName()));
            }
        }
    }

    private BaseAdapter alE() {
        return new BaseAdapter() { // from class: com.baidu.swan.apps.core.d.b.5
            @Override // android.widget.Adapter
            public int getCount() {
                return b.this.mList.size();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.widget.Adapter
            /* renamed from: hL */
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
                    aVar.cEf = (CheckBox) view.findViewById(a.f.checkbox);
                    aVar.title = (TextView) view.findViewById(a.f.title);
                    view.setTag(aVar);
                }
                a aVar2 = (a) view.getTag();
                com.baidu.swan.apps.setting.oauth.e item = getItem(i);
                String str = TextUtils.isEmpty(item.drV) ? item.name : item.drV;
                TextView textView = aVar2.title;
                if (TextUtils.isEmpty(str)) {
                    str = "";
                }
                textView.setText(str);
                aVar2.cEf.setChecked(item.aGR());
                return view;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.swan.apps.setting.oauth.e eVar) {
        if (eVar instanceof C0410b) {
            a((C0410b) eVar);
        } else {
            b(eVar, !eVar.aGR());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.setting.oauth.e eVar, boolean z) {
        eVar.drY = z ? 1 : -1;
        this.cEb.notifyDataSetChanged();
    }

    private void b(final com.baidu.swan.apps.setting.oauth.e eVar, boolean z) {
        com.baidu.swan.apps.runtime.e alC = alC();
        if (alC == null) {
            this.cEc = false;
            return;
        }
        com.baidu.swan.apps.res.widget.loadingview.a.showLoadingView(bah(), this.bEh);
        alC.aFg().a(bah(), eVar.id, false, z, true, new com.baidu.swan.apps.ap.e.b<com.baidu.swan.apps.setting.oauth.h<b.d>>() { // from class: com.baidu.swan.apps.core.d.b.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: a */
            public void M(com.baidu.swan.apps.setting.oauth.h<b.d> hVar) {
                FragmentActivity bah = b.this.bah();
                if (bah != null) {
                    com.baidu.swan.apps.res.widget.loadingview.a.dismissLoadingView(b.this.bEh);
                    if (hVar != null && hVar.isOk()) {
                        b.this.a(eVar, hVar.mData.drU);
                    } else {
                        com.baidu.swan.apps.res.widget.b.d.k(bah, a.h.aiapps_setting_scope_auth_failed).showToast();
                    }
                    b.this.cEc = false;
                }
            }
        });
    }

    /* loaded from: classes10.dex */
    class a {
        CheckBox cEf;
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
        com.baidu.swan.apps.runtime.e alC = alC();
        if (alC != null) {
            alC.aFg().aGE();
        }
        if (DEBUG) {
            Log.d("SwanAppAuthoritySettingFragment", "onDestroy() obj: " + this);
        }
    }

    public static b alF() {
        return new b();
    }

    @Override // com.baidu.swan.apps.core.d.c, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        return true;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean alq() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean agb() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void agI() {
    }
}
