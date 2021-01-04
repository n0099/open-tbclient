package com.baidu.swan.apps.api.module.e;

import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.ao.j;
import com.baidu.swan.apps.res.ui.BdMultiPicker;
import com.baidu.swan.apps.res.widget.dialog.d;
import com.baidu.swan.apps.res.widget.dialog.e;
import com.baidu.swan.apps.res.widget.dialog.i;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class e extends com.baidu.swan.apps.api.a.d {
    private com.baidu.swan.apps.res.widget.dialog.h cIS;

    public e(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b lo(String str) {
        if (TextUtils.isEmpty(str)) {
            return new com.baidu.swan.apps.api.c.b(202);
        }
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> bo = com.baidu.swan.apps.api.d.b.bo("showDatePickerView", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) bo.first;
        if (!bVar.isSuccess()) {
            com.baidu.swan.apps.console.c.e("Api-Base", "parse fail");
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) bo.second;
        if (jSONObject == null) {
            com.baidu.swan.apps.console.c.e("Api-Base", "paramsJson is null");
            return new com.baidu.swan.apps.api.c.b(1001);
        }
        String optString = jSONObject.optString(UbcStatConstant.KEY_CONTENT_EXT_MODE);
        if (TextUtils.isEmpty(optString)) {
            return new com.baidu.swan.apps.api.c.b(202);
        }
        char c = 65535;
        switch (optString.hashCode()) {
            case 3076014:
                if (optString.equals("date")) {
                    c = 1;
                    break;
                }
                break;
            case 3560141:
                if (optString.equals("time")) {
                    c = 0;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return aO(jSONObject);
            case 1:
                return aP(jSONObject);
            default:
                return new com.baidu.swan.apps.api.c.b(202);
        }
    }

    private com.baidu.swan.apps.api.c.b aO(JSONObject jSONObject) {
        final boolean optBoolean = jSONObject.optBoolean("disabled", false);
        String optString = jSONObject.optString("start");
        String optString2 = jSONObject.optString("end");
        String optString3 = jSONObject.optString("value");
        final String optString4 = jSONObject.optString("fields");
        if (TextUtils.isEmpty(optString)) {
            optString = "00:00";
        }
        if (TextUtils.isEmpty(optString2)) {
            optString2 = "23:59";
        }
        final Date ls = ls(optString);
        final Date ls2 = ls(optString2);
        final Date ls3 = ls(optString3);
        if (ls3 == null) {
            ls3 = ls(new SimpleDateFormat("HH:mm").format(new Date()));
        }
        if (ls == null || ls2 == null || ls2.before(ls) || ls3 == null) {
            return new com.baidu.swan.apps.api.c.b(202);
        }
        final String optString5 = jSONObject.optString("cb");
        if (TextUtils.isEmpty(optString5)) {
            com.baidu.swan.apps.console.c.e("Api-Base", "callback is null");
            return new com.baidu.swan.apps.api.c.b(1001, "callback is null");
        }
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.api.module.e.e.1
            @Override // java.lang.Runnable
            public void run() {
                i.a aVar = new i.a(e.this.getContext());
                if (!TextUtils.isEmpty(optString4)) {
                    aVar.sq(optString4);
                }
                aVar.i(ls).j(ls2).k(ls3).hc(optBoolean).hb(true).f(a.h.aiapps_ok, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.api.module.e.e.1.3
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        String format = String.format("%02d:%02d", Integer.valueOf(((i) dialogInterface).getHour()), Integer.valueOf(((i) dialogInterface).getMinute()));
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put("value", format);
                            if (com.baidu.swan.apps.api.a.d.DEBUG) {
                                Log.d("Api-Base", "handleShowDatePicker params = " + jSONObject2.toString());
                            }
                            e.this.a(optString5, new com.baidu.swan.apps.api.c.b(0, jSONObject2));
                        } catch (JSONException e) {
                            if (com.baidu.swan.apps.api.a.d.DEBUG) {
                                e.printStackTrace();
                            }
                        }
                    }
                }).g(a.h.aiapps_cancel, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.api.module.e.e.1.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        e.this.a(optString5, new com.baidu.swan.apps.api.c.b(0));
                        dialogInterface.dismiss();
                    }
                }).c(new DialogInterface.OnCancelListener() { // from class: com.baidu.swan.apps.api.module.e.e.1.1
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        e.this.a(optString5, new com.baidu.swan.apps.api.c.b(0));
                        dialogInterface.dismiss();
                    }
                }).aLC();
            }
        });
        return new com.baidu.swan.apps.api.c.b(0);
    }

    private com.baidu.swan.apps.api.c.b aP(JSONObject jSONObject) {
        final Date date;
        final boolean optBoolean = jSONObject.optBoolean("disabled", false);
        String optString = jSONObject.optString("start");
        String optString2 = jSONObject.optString("end");
        String optString3 = jSONObject.optString("value");
        final String optString4 = jSONObject.optString("fields");
        String[] strArr = {"yyyy-MM-dd", "yyyy-MM", "yyyy"};
        final Date a2 = a(optString, strArr, "1900-01-01");
        final Date a3 = a(optString2, strArr, "2099-12-31");
        if (a2 == null || a3 == null || a3.before(a2)) {
            return new com.baidu.swan.apps.api.c.b(202);
        }
        final String optString5 = jSONObject.optString("cb");
        if (TextUtils.isEmpty(optString5)) {
            com.baidu.swan.apps.console.c.e("Api-Base", "callback is null");
            return new com.baidu.swan.apps.api.c.b(1001, "callback is null");
        }
        Date a4 = a(optString3, strArr, (String) null);
        if (a4 == null) {
            a4 = new Date();
        }
        if (a4.before(a2)) {
            date = a2;
        } else {
            date = a4.after(a3) ? a3 : a4;
        }
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.api.module.e.e.2
            @Override // java.lang.Runnable
            public void run() {
                d.a aVar = new d.a(e.this.getContext());
                if (!TextUtils.isEmpty(optString4)) {
                    aVar.so(optString4);
                }
                aVar.f(a2).g(a3).h(date).gQ(optBoolean).hb(true).f(a.h.aiapps_ok, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.api.module.e.e.2.3
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        if (dialogInterface instanceof com.baidu.swan.apps.res.widget.dialog.d) {
                            String aLn = ((com.baidu.swan.apps.res.widget.dialog.d) dialogInterface).aLn();
                            JSONObject jSONObject2 = new JSONObject();
                            try {
                                jSONObject2.put("value", aLn);
                                if (com.baidu.swan.apps.api.a.d.DEBUG) {
                                    Log.d("Api-Base", "handleShowDatePicker params = " + jSONObject2.toString());
                                }
                                e.this.a(optString5, new com.baidu.swan.apps.api.c.b(0, jSONObject2));
                            } catch (JSONException e) {
                                if (com.baidu.swan.apps.api.a.d.DEBUG) {
                                    e.printStackTrace();
                                }
                                e.this.a(optString5, new com.baidu.swan.apps.api.c.b(202));
                            }
                        }
                    }
                }).g(a.h.aiapps_cancel, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.api.module.e.e.2.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        e.this.a(optString5, new com.baidu.swan.apps.api.c.b(0));
                        dialogInterface.dismiss();
                    }
                }).c(new DialogInterface.OnCancelListener() { // from class: com.baidu.swan.apps.api.module.e.e.2.1
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        e.this.a(optString5, new com.baidu.swan.apps.api.c.b(0));
                        dialogInterface.dismiss();
                    }
                }).aLC();
            }
        });
        return new com.baidu.swan.apps.api.c.b(0);
    }

    private Date a(String str, String[] strArr, String str2) {
        Date date = null;
        if (!TextUtils.isEmpty(str)) {
            date = j.f(str, strArr);
        }
        if (date == null && !TextUtils.isEmpty(str2)) {
            return j.f(str2, strArr);
        }
        return date;
    }

    public com.baidu.swan.apps.api.c.b lp(String str) {
        if (TextUtils.isEmpty(str)) {
            return new com.baidu.swan.apps.api.c.b(202);
        }
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> bo = com.baidu.swan.apps.api.d.b.bo("showDatePickerView", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) bo.first;
        if (!bVar.isSuccess()) {
            com.baidu.swan.apps.console.c.e("Api-Base", "parse fail");
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) bo.second;
        if (jSONObject == null) {
            return new com.baidu.swan.apps.api.c.b(202);
        }
        JSONArray optJSONArray = jSONObject.optJSONArray(com.baidu.fsg.base.statistics.b.j);
        int optInt = jSONObject.optInt("current");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            return new com.baidu.swan.apps.api.c.b(202);
        }
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(optJSONArray);
        JSONArray jSONArray2 = new JSONArray();
        jSONArray2.put(optInt);
        try {
            jSONObject.put(com.baidu.fsg.base.statistics.b.j, jSONArray);
            jSONObject.put("current", jSONArray2);
            return d(jSONObject, true);
        } catch (JSONException e) {
            return new com.baidu.swan.apps.api.c.b(1001);
        }
    }

    public com.baidu.swan.apps.api.c.b lq(String str) {
        if (TextUtils.isEmpty(str)) {
            return new com.baidu.swan.apps.api.c.b(202);
        }
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> bo = com.baidu.swan.apps.api.d.b.bo("showDatePickerView", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) bo.first;
        if (!bVar.isSuccess()) {
            com.baidu.swan.apps.console.c.e("Api-Base", "parse fail");
            return bVar;
        }
        return d((JSONObject) bo.second, false);
    }

    public com.baidu.swan.apps.api.c.b lr(String str) {
        if (TextUtils.isEmpty(str)) {
            return new com.baidu.swan.apps.api.c.b(202);
        }
        if (this.cIS == null) {
            return new com.baidu.swan.apps.api.c.b(1001);
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            final int optInt = jSONObject.optInt("column");
            final JSONArray optJSONArray = jSONObject.optJSONArray(com.baidu.fsg.base.statistics.b.j);
            final int optInt2 = jSONObject.optInt("current");
            String optString = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                com.baidu.swan.apps.console.c.e("Api-Base", "callback is null");
                return new com.baidu.swan.apps.api.c.b(1001, "callback is null");
            }
            if (optJSONArray != null) {
                ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.api.module.e.e.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (e.this.cIS != null) {
                            ((com.baidu.swan.apps.res.widget.dialog.e) e.this.cIS).a(optInt, optJSONArray, optInt2);
                        }
                    }
                });
                a(optString, new com.baidu.swan.apps.api.c.b(0, jSONObject));
            }
            return new com.baidu.swan.apps.api.c.b(0);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            return new com.baidu.swan.apps.api.c.b(202);
        }
    }

    private com.baidu.swan.apps.api.c.b d(final JSONObject jSONObject, final boolean z) {
        if (this.cIS != null) {
            return new com.baidu.swan.apps.api.c.b(1001);
        }
        if (DEBUG) {
            Log.i("Api-Base", "handleOpenMultiPicker: input params=" + jSONObject);
        }
        final JSONArray jSONArray = new JSONArray();
        final JSONArray jSONArray2 = new JSONArray();
        final String str = null;
        if (jSONObject != null) {
            jSONArray = jSONObject.optJSONArray(com.baidu.fsg.base.statistics.b.j);
            jSONArray2 = jSONObject.optJSONArray("current");
            str = jSONObject.optString("cb");
        }
        if (TextUtils.isEmpty(str)) {
            com.baidu.swan.apps.console.c.e("Api-Base", "callback is null");
            return new com.baidu.swan.apps.api.c.b(1001, "callback is null");
        }
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.api.module.e.e.4
            @Override // java.lang.Runnable
            public void run() {
                e.a aVar = new e.a(e.this.getContext());
                e.this.cIS = aVar.F(jSONArray).G(jSONArray2).gS(z).a(new BdMultiPicker.a() { // from class: com.baidu.swan.apps.api.module.e.e.4.4
                    @Override // com.baidu.swan.apps.res.ui.BdMultiPicker.a
                    public void a(BdMultiPicker bdMultiPicker, JSONObject jSONObject2) {
                        if (com.baidu.swan.apps.api.a.d.DEBUG) {
                            Log.i("Api-Base", "onMultiSelectedChanged: params=" + jSONObject);
                        }
                        try {
                            JSONObject jSONObject3 = new JSONObject(jSONObject2.toString());
                            jSONObject3.put("type", "columnChange");
                            e.this.a(str, new com.baidu.swan.apps.api.c.b(0, jSONObject3));
                        } catch (JSONException e) {
                            if (com.baidu.swan.apps.api.a.d.DEBUG) {
                                e.printStackTrace();
                            }
                            e.this.a(str, new com.baidu.swan.apps.api.c.b(202));
                        }
                    }
                }).hb(true).f(a.h.aiapps_ok, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.api.module.e.e.4.3
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        e.this.cIS = null;
                        try {
                            JSONArray currentIndex = ((com.baidu.swan.apps.res.widget.dialog.e) dialogInterface).getCurrentIndex();
                            JSONObject jSONObject2 = new JSONObject();
                            if (currentIndex != null && currentIndex.length() > 0) {
                                if (z) {
                                    jSONObject2.put("value", currentIndex.optInt(0));
                                } else {
                                    jSONObject2.put("value", currentIndex);
                                    jSONObject2.put("type", "confirm");
                                }
                            }
                            e.this.a(str, new com.baidu.swan.apps.api.c.b(0, jSONObject2));
                            if (com.baidu.swan.apps.api.a.d.DEBUG) {
                                Log.i("Api-Base", "handleOpenMultiPicker: output params = " + jSONObject2.toString());
                            }
                        } catch (JSONException e) {
                            if (com.baidu.swan.apps.api.a.d.DEBUG) {
                                e.printStackTrace();
                            }
                        }
                    }
                }).g(a.h.aiapps_cancel, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.api.module.e.e.4.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        e.this.a(dialogInterface, z, str);
                    }
                }).c(new DialogInterface.OnCancelListener() { // from class: com.baidu.swan.apps.api.module.e.e.4.1
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        e.this.a(dialogInterface, z, str);
                    }
                }).aLC();
            }
        });
        return new com.baidu.swan.apps.api.c.b(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DialogInterface dialogInterface, boolean z, String str) {
        dialogInterface.dismiss();
        this.cIS = null;
        if (z) {
            a(str, new com.baidu.swan.apps.api.c.b(0));
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "cancel");
            a(str, new com.baidu.swan.apps.api.c.b(0, jSONObject));
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            a(str, new com.baidu.swan.apps.api.c.b(202));
        }
    }

    private Date ls(String str) {
        String[] split;
        Date date;
        if (TextUtils.isEmpty(str)) {
            return new Date();
        }
        if (!str.contains(":") || (split = str.split(":")) == null || split.length != 2) {
            return null;
        }
        try {
            date = new Date();
        } catch (NumberFormatException e) {
            e = e;
            date = null;
        }
        try {
            int parseInt = Integer.parseInt(split[0]);
            if (parseInt >= 0 && parseInt < 24) {
                date.setHours(parseInt);
            }
            int parseInt2 = Integer.parseInt(split[1]);
            if (parseInt2 >= 0 && parseInt2 < 60) {
                date.setMinutes(parseInt2);
                return date;
            }
            return date;
        } catch (NumberFormatException e2) {
            e = e2;
            if (DEBUG) {
                e.printStackTrace();
                return date;
            }
            return date;
        }
    }
}
