package com.baidu.swan.apps.scheme.actions.d;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.widget.dialog.f;
import com.baidu.swan.apps.res.widget.dialog.g;
import com.baidu.swan.apps.scheme.actions.z;
import com.baidu.swan.apps.scheme.j;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c extends z {
    public c(j jVar) {
        super(jVar, "/swan/showActionSheet");
    }

    @Override // com.baidu.swan.apps.scheme.actions.z
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        if (context == null || bVar == null) {
            com.baidu.swan.apps.console.c.e("ShowActionSheet", "aiapp is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        return n(context, unitedSchemeEntity, callbackHandler);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean n(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler) {
        int i;
        String optString;
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        final ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = optParamsAsJo.getJSONArray("itemList");
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                String string = jSONArray.getString(i2);
                if (TextUtils.isEmpty(string)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    return false;
                }
                arrayList.add(string);
            }
            optString = optParamsAsJo.optString("itemColor");
        } catch (IllegalArgumentException | JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        if (!TextUtils.isEmpty(optString)) {
            if (optString.length() == 4 && optString.charAt(0) == '#') {
                optString = com.baidu.swan.apps.ae.a.c.ht(optString);
            }
            i = Color.parseColor(optString);
            if (!arrayList.isEmpty()) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            final int color = i == -1 ? context.getResources().getColor(a.c.aiapps_action_sheet_item_color) : i;
            g.a b = new f(context).ct(true).cA(true).cy(true).cz(false).cv(true).a(new com.baidu.swan.apps.view.b.a()).eo(context.getResources().getDimensionPixelSize(a.d.aiapps_action_sheet_bottom_divider)).ew(a.e.aiapps_action_sheet_bg).eu(a.c.aiapps_action_sheet_cancel_text).c(a.h.aiapps_cancel, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.scheme.actions.d.c.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(201, "showActionSheet:fail cancel"));
                }
            }).b(new DialogInterface.OnCancelListener() { // from class: com.baidu.swan.apps.scheme.actions.d.c.1
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(201, "showActionSheet:fail cancel"));
                }
            });
            View inflate = View.inflate(context, a.g.aiapps_scheme_utils_show_action_sheet, null);
            ListView listView = (ListView) inflate.findViewById(a.f.list);
            listView.setAdapter((ListAdapter) new BaseAdapter() { // from class: com.baidu.swan.apps.scheme.actions.d.c.3
                @Override // android.widget.Adapter
                public int getCount() {
                    return arrayList.size();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // android.widget.Adapter
                public String getItem(int i3) {
                    return (String) arrayList.get(i3);
                }

                @Override // android.widget.Adapter
                public long getItemId(int i3) {
                    return i3;
                }

                @Override // android.widget.Adapter
                public View getView(int i3, View view, ViewGroup viewGroup) {
                    if (view == null) {
                        view = View.inflate(context, a.g.aiapps_scheme_utils_show_action_sheet_item, null);
                    }
                    TextView textView = (TextView) view.findViewById(a.f.text);
                    textView.setTextColor(color);
                    textView.setText(getItem(i3));
                    return view;
                }
            });
            b.al(inflate);
            b.Qt();
            b.ep(j(context, arrayList.size()));
            final g FX = b.FX();
            Window window = FX.getWindow();
            if (window != null) {
                window.setGravity(80);
                window.setDimAmount(0.65f);
                window.setLayout(com.baidu.swan.apps.an.z.bT(context), -2);
                window.setWindowAnimations(a.i.action_sheet_animation);
            }
            FX.cp(false);
            FX.setCanceledOnTouchOutside(true);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.swan.apps.scheme.actions.d.c.4
                @Override // android.widget.AdapterView.OnItemClickListener
                public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("tapIndex", i3);
                        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
                        FX.dismiss();
                    } catch (JSONException e2) {
                        if (c.DEBUG) {
                            e2.printStackTrace();
                        }
                        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(201));
                    }
                }
            });
            FX.show();
            return true;
        }
        i = -1;
        if (!arrayList.isEmpty()) {
        }
    }

    private int j(Context context, int i) {
        int bT;
        Resources resources = context.getResources();
        int dimensionPixelSize = ((resources.getDimensionPixelSize(a.d.aiapps_action_sheet_bottom_divider) + ((i + 1) * resources.getDimensionPixelSize(a.d.aiapps_action_sheet_list_item))) + i) - 1;
        return (!com.baidu.swan.apps.an.z.Uu() || dimensionPixelSize <= (bT = com.baidu.swan.apps.an.z.bT(context) - com.baidu.swan.apps.an.z.getStatusBarHeight())) ? dimensionPixelSize : bT;
    }
}
