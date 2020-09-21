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
/* loaded from: classes3.dex */
public class b extends c implements AdapterView.OnItemClickListener {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static String cjl = "pref_close_scope_alert_showed";
    private BaseAdapter cjm;
    private FrameLayout cjn;
    private final List<com.baidu.swan.apps.setting.oauth.e> mList = new ArrayList();
    private boolean cjo = false;

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
        ak(inflate);
        this.cjn = (FrameLayout) inflate.findViewById(a.f.container);
        this.cjm = agZ();
        ListView listView = (ListView) inflate.findViewById(a.f.ai_apps_setting_list);
        listView.setAdapter((ListAdapter) this.cjm);
        listView.setOnItemClickListener(this);
        return enableSliding(immersionEnabled() ? initImmersion(inflate) : inflate, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public void ak(View view) {
        an(view);
        he(-1);
        hf(ViewCompat.MEASURED_STATE_MASK);
        lA(getString(a.h.common_menu_authority_management));
        dU(true);
        setRightZoneVisibility(false);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        initData();
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void agK() {
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected boolean abW() {
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
        if (!this.cjo) {
            com.baidu.swan.apps.setting.oauth.e eVar = this.mList.get(i);
            this.cjo = true;
            if (!eVar.aCo() || agX().aAD().getBoolean(cjl, false)) {
                com.baidu.swan.apps.setting.oauth.c.c("onItemClick : " + eVar, false);
                b(eVar);
                return;
            }
            a(eVar);
        }
    }

    @UiThread
    private void a(@NonNull C0379b c0379b) {
        FragmentActivity aVF = aVF();
        if (aVF == null) {
            this.cjo = false;
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("result", Integer.valueOf(!c0379b.aCo() ? 1 : -1));
        if (aVF.getContentResolver().update(SwanAppSubscribeMsgProvider.CONTENT_URI, contentValues, "_id=?", new String[]{c0379b.id}) > 0) {
            c0379b.cXo = c0379b.aCo() ? -1 : 1;
            this.cjm.notifyDataSetChanged();
        }
        this.cjo = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @UiThread
    public void E(@NonNull Activity activity) {
        com.baidu.swan.apps.runtime.e aAs = com.baidu.swan.apps.runtime.e.aAs();
        if (aAs != null) {
            Cursor query = activity.getContentResolver().query(SwanAppSubscribeMsgProvider.CONTENT_URI, new String[]{IMConstants.MSG_ROW_ID, "title", "result"}, "appKey=?", new String[]{aAs.getAppKey()}, null);
            if (query != null) {
                if (query.getCount() > 0) {
                    while (query.moveToNext()) {
                        int i = query.getInt(query.getColumnIndex(IMConstants.MSG_ROW_ID));
                        String string = query.getString(query.getColumnIndex("title"));
                        int i2 = query.getInt(query.getColumnIndex("result"));
                        C0379b c0379b = new C0379b(String.valueOf(i));
                        c0379b.name = string;
                        c0379b.cXo = i2 == -1 ? -1 : 1;
                        this.mList.add(c0379b);
                    }
                    agY();
                    this.cjm.notifyDataSetChanged();
                }
                com.baidu.swan.c.d.closeSafely(query);
            }
        }
    }

    private void a(final com.baidu.swan.apps.setting.oauth.e eVar) {
        new g.a(aVF()).hn(a.h.aiapps_setting_scope_close_alert_title).hm(a.h.aiapps_setting_scope_close_alert_msg).a(new com.baidu.swan.apps.view.c.a()).c(a.h.aiapps_setting_scope_close_alert_btn_pos, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.b.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                b.this.agX().aAD().putBoolean(b.cjl, true);
                b.this.b(eVar);
            }
        }).d(a.h.aiapps_cancel, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.b.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                b.this.cjo = false;
            }
        }).fz(true).a(new DialogInterface.OnCancelListener() { // from class: com.baidu.swan.apps.core.d.b.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                b.this.cjo = false;
            }
        }).azY();
    }

    private void initData() {
        com.baidu.swan.apps.res.widget.loadingview.a.showLoadingView(aVF(), this.cjn);
        this.mList.clear();
        this.cjm.notifyDataSetChanged();
        com.baidu.swan.apps.network.c.b.a.s(new com.baidu.swan.apps.ap.e.b<Map<String, com.baidu.swan.apps.setting.oauth.e>>() { // from class: com.baidu.swan.apps.core.d.b.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: n */
            public void J(Map<String, com.baidu.swan.apps.setting.oauth.e> map) {
                FragmentActivity aVF = b.this.aVF();
                if (aVF != null && !aVF.isFinishing() && !aVF.isDestroyed()) {
                    com.baidu.swan.apps.res.widget.loadingview.a.dismissLoadingView(b.this.cjn);
                    if (map == null) {
                        b.this.E(aVF);
                        return;
                    }
                    for (Map.Entry<String, com.baidu.swan.apps.setting.oauth.e> entry : map.entrySet()) {
                        com.baidu.swan.apps.setting.oauth.e value = entry.getValue();
                        if (!TextUtils.isEmpty(entry.getKey()) && value != null && !value.forbidden && value.aCp() && "2".equals(value.grade) && !"snsapi_base".equals(value.id)) {
                            b.this.mList.add(value);
                        }
                    }
                    b.this.agY();
                    b.this.cjm.notifyDataSetChanged();
                    b.this.E(aVF);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.core.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0379b extends com.baidu.swan.apps.setting.oauth.e {
        C0379b(String str) {
            super(str);
        }
    }

    @Nullable
    public com.baidu.swan.apps.runtime.e agX() {
        return com.baidu.swan.apps.v.f.asJ().agX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void agY() {
        View view = getView();
        if (view != null) {
            boolean isEmpty = this.mList.isEmpty();
            TextView textView = (TextView) view.findViewById(a.f.tips);
            textView.setVisibility(isEmpty ? 8 : 0);
            if (!isEmpty) {
                textView.setText(getString(a.h.aiapps_setting_tips, agX().getName()));
            }
            View findViewById = view.findViewById(a.f.id_empty_container);
            if (findViewById != null) {
                findViewById.setVisibility(isEmpty ? 0 : 8);
            }
            TextView textView2 = (TextView) view.findViewById(a.f.empty);
            if (isEmpty) {
                textView2.setText(getString(a.h.aiapps_setting_empty, agX().getName()));
            }
        }
    }

    private BaseAdapter agZ() {
        return new BaseAdapter() { // from class: com.baidu.swan.apps.core.d.b.5
            @Override // android.widget.Adapter
            public int getCount() {
                return b.this.mList.size();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.widget.Adapter
            /* renamed from: hd */
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
                    aVar.cjr = (CheckBox) view.findViewById(a.f.checkbox);
                    aVar.title = (TextView) view.findViewById(a.f.title);
                    view.setTag(aVar);
                }
                a aVar2 = (a) view.getTag();
                com.baidu.swan.apps.setting.oauth.e item = getItem(i);
                String str = TextUtils.isEmpty(item.cXl) ? item.name : item.cXl;
                TextView textView = aVar2.title;
                if (TextUtils.isEmpty(str)) {
                    str = "";
                }
                textView.setText(str);
                aVar2.cjr.setChecked(item.aCo());
                return view;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.swan.apps.setting.oauth.e eVar) {
        if (eVar instanceof C0379b) {
            a((C0379b) eVar);
        } else {
            b(eVar, !eVar.aCo());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.setting.oauth.e eVar, boolean z) {
        eVar.cXo = z ? 1 : -1;
        this.cjm.notifyDataSetChanged();
    }

    private void b(final com.baidu.swan.apps.setting.oauth.e eVar, boolean z) {
        com.baidu.swan.apps.runtime.e agX = agX();
        if (agX == null) {
            this.cjo = false;
            return;
        }
        com.baidu.swan.apps.res.widget.loadingview.a.showLoadingView(aVF(), this.cjn);
        agX.aAD().a(aVF(), eVar.id, false, z, true, new com.baidu.swan.apps.ap.e.b<com.baidu.swan.apps.setting.oauth.h<b.d>>() { // from class: com.baidu.swan.apps.core.d.b.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: a */
            public void J(com.baidu.swan.apps.setting.oauth.h<b.d> hVar) {
                FragmentActivity aVF = b.this.aVF();
                if (aVF != null) {
                    com.baidu.swan.apps.res.widget.loadingview.a.dismissLoadingView(b.this.cjn);
                    if (hVar != null && hVar.isOk()) {
                        b.this.a(eVar, hVar.mData.cXk);
                    } else {
                        com.baidu.swan.apps.res.widget.b.d.k(aVF, a.h.aiapps_setting_scope_auth_failed).showToast();
                    }
                    b.this.cjo = false;
                }
            }
        });
    }

    /* loaded from: classes3.dex */
    class a {
        CheckBox cjr;
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
        com.baidu.swan.apps.runtime.e agX = agX();
        if (agX != null) {
            agX.aAD().aCb();
        }
        if (DEBUG) {
            Log.d("SwanAppAuthoritySettingFragment", "onDestroy() obj: " + this);
        }
    }

    public static b aha() {
        return new b();
    }

    @Override // com.baidu.swan.apps.core.d.c, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        return true;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean agL() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean abv() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void acc() {
    }
}
