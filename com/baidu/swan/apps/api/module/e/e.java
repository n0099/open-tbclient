package com.baidu.swan.apps.api.module.e;

import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.baidu.searchbox.ui.animview.praise.guide.ControlShowManager;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.res.ui.BdMultiPicker;
import com.baidu.swan.apps.res.widget.dialog.d;
import com.baidu.swan.apps.res.widget.dialog.e;
import com.baidu.swan.apps.res.widget.dialog.i;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class e extends com.baidu.swan.apps.api.a.d {
    private com.baidu.swan.apps.res.widget.dialog.h bKX;

    public e(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b hs(String str) {
        if (TextUtils.isEmpty(str)) {
            return new com.baidu.swan.apps.api.c.b(202);
        }
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> aP = com.baidu.swan.apps.api.d.b.aP("showDatePickerView", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) aP.first;
        if (!bVar.isSuccess()) {
            com.baidu.swan.apps.console.c.e("Api-Base", "parse fail");
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) aP.second;
        if (jSONObject == null) {
            com.baidu.swan.apps.console.c.e("Api-Base", "paramsJson is null");
            return new com.baidu.swan.apps.api.c.b(1001);
        }
        String optString = jSONObject.optString("mode");
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
                return ah(jSONObject);
            case 1:
                return ai(jSONObject);
            default:
                return new com.baidu.swan.apps.api.c.b(202);
        }
    }

    private com.baidu.swan.apps.api.c.b ah(JSONObject jSONObject) {
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
        final Date hw = hw(optString);
        final Date hw2 = hw(optString2);
        final Date hw3 = hw(optString3);
        if (hw3 == null) {
            hw3 = hw(new SimpleDateFormat("HH:mm").format(new Date()));
        }
        if (hw == null || hw2 == null || hw2.before(hw) || hw3 == null) {
            return new com.baidu.swan.apps.api.c.b(202);
        }
        final String optString5 = jSONObject.optString("cb");
        if (TextUtils.isEmpty(optString5)) {
            com.baidu.swan.apps.console.c.e("Api-Base", "callback is null");
            return new com.baidu.swan.apps.api.c.b(1001, "callback is null");
        }
        aj.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.api.module.e.e.1
            @Override // java.lang.Runnable
            public void run() {
                i.a aVar = new i.a(e.this.getContext());
                if (!TextUtils.isEmpty(optString4)) {
                    aVar.nr(optString4);
                }
                aVar.g(hw).h(hw2).i(hw3).fa(optBoolean).eZ(true).f(a.h.aiapps_ok, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.api.module.e.e.1.3
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
                }).b(new DialogInterface.OnCancelListener() { // from class: com.baidu.swan.apps.api.module.e.e.1.1
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        e.this.a(optString5, new com.baidu.swan.apps.api.c.b(0));
                        dialogInterface.dismiss();
                    }
                }).aop();
            }
        });
        return new com.baidu.swan.apps.api.c.b(0);
    }

    private com.baidu.swan.apps.api.c.b ai(JSONObject jSONObject) {
        final Date date;
        final boolean optBoolean = jSONObject.optBoolean("disabled", false);
        String optString = jSONObject.optString("start");
        String optString2 = jSONObject.optString("end");
        String optString3 = jSONObject.optString("value");
        final String optString4 = jSONObject.optString("fields");
        String[] strArr = {ControlShowManager.DAY_TIME_FORMAT, "yyyy-MM", "yyyy"};
        final Date a = a(optString, strArr, "1900-01-01");
        final Date a2 = a(optString2, strArr, "2099-12-31");
        if (a == null || a2 == null || a2.before(a)) {
            return new com.baidu.swan.apps.api.c.b(202);
        }
        final String optString5 = jSONObject.optString("cb");
        if (TextUtils.isEmpty(optString5)) {
            com.baidu.swan.apps.console.c.e("Api-Base", "callback is null");
            return new com.baidu.swan.apps.api.c.b(1001, "callback is null");
        }
        Date a3 = a(optString3, strArr, (String) null);
        if (a3 == null) {
            a3 = new Date();
        }
        if (a3.before(a)) {
            date = a;
        } else {
            date = a3.after(a2) ? a2 : a3;
        }
        aj.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.api.module.e.e.2
            @Override // java.lang.Runnable
            public void run() {
                d.a aVar = new d.a(e.this.getContext());
                if (!TextUtils.isEmpty(optString4)) {
                    aVar.np(optString4);
                }
                aVar.d(a).e(a2).f(date).eO(optBoolean).eZ(true).f(a.h.aiapps_ok, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.api.module.e.e.2.3
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        if (dialogInterface instanceof com.baidu.swan.apps.res.widget.dialog.d) {
                            String aoe = ((com.baidu.swan.apps.res.widget.dialog.d) dialogInterface).aoe();
                            JSONObject jSONObject2 = new JSONObject();
                            try {
                                jSONObject2.put("value", aoe);
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
                }).b(new DialogInterface.OnCancelListener() { // from class: com.baidu.swan.apps.api.module.e.e.2.1
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        e.this.a(optString5, new com.baidu.swan.apps.api.c.b(0));
                        dialogInterface.dismiss();
                    }
                }).aop();
            }
        });
        return new com.baidu.swan.apps.api.c.b(0);
    }

    private Date a(String str, String[] strArr, String str2) {
        Date date = null;
        if (!TextUtils.isEmpty(str)) {
            date = com.baidu.swan.apps.aq.i.e(str, strArr);
        }
        if (date == null && !TextUtils.isEmpty(str2)) {
            return com.baidu.swan.apps.aq.i.e(str2, strArr);
        }
        return date;
    }

    public com.baidu.swan.apps.api.c.b ht(String str) {
        if (TextUtils.isEmpty(str)) {
            return new com.baidu.swan.apps.api.c.b(202);
        }
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> aP = com.baidu.swan.apps.api.d.b.aP("showDatePickerView", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) aP.first;
        if (!bVar.isSuccess()) {
            com.baidu.swan.apps.console.c.e("Api-Base", "parse fail");
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) aP.second;
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
            return b(jSONObject, true);
        } catch (JSONException e) {
            return new com.baidu.swan.apps.api.c.b(1001);
        }
    }

    public com.baidu.swan.apps.api.c.b hu(String str) {
        if (TextUtils.isEmpty(str)) {
            return new com.baidu.swan.apps.api.c.b(202);
        }
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> aP = com.baidu.swan.apps.api.d.b.aP("showDatePickerView", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) aP.first;
        if (!bVar.isSuccess()) {
            com.baidu.swan.apps.console.c.e("Api-Base", "parse fail");
            return bVar;
        }
        return b((JSONObject) aP.second, false);
    }

    public com.baidu.swan.apps.api.c.b hv(String str) {
        if (TextUtils.isEmpty(str)) {
            return new com.baidu.swan.apps.api.c.b(202);
        }
        if (this.bKX == null) {
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
                aj.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.api.module.e.e.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (e.this.bKX != null) {
                            ((com.baidu.swan.apps.res.widget.dialog.e) e.this.bKX).a(optInt, optJSONArray, optInt2);
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

    private com.baidu.swan.apps.api.c.b b(final JSONObject jSONObject, final boolean z) {
        if (this.bKX != null) {
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
        aj.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.api.module.e.e.4
            @Override // java.lang.Runnable
            public void run() {
                e.a aVar = new e.a(e.this.getContext());
                e.this.bKX = aVar.B(jSONArray).C(jSONArray2).eQ(z).a(new BdMultiPicker.a() { // from class: com.baidu.swan.apps.api.module.e.e.4.4
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
                }).eZ(true).f(a.h.aiapps_ok, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.api.module.e.e.4.3
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        e.this.bKX = null;
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
                }).b(new DialogInterface.OnCancelListener() { // from class: com.baidu.swan.apps.api.module.e.e.4.1
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        e.this.a(dialogInterface, z, str);
                    }
                }).aop();
            }
        });
        return new com.baidu.swan.apps.api.c.b(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DialogInterface dialogInterface, boolean z, String str) {
        dialogInterface.dismiss();
        this.bKX = null;
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

    private Date hw(String str) {
        String[] split;
        Date date;
        NumberFormatException e;
        if (TextUtils.isEmpty(str)) {
            return new Date();
        }
        if (!str.contains(":") || (split = str.split(":")) == null || split.length != 2) {
            return null;
        }
        try {
            date = new Date();
        } catch (NumberFormatException e2) {
            date = null;
            e = e2;
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
        } catch (NumberFormatException e3) {
            e = e3;
            if (DEBUG) {
                e.printStackTrace();
                return date;
            }
            return date;
        }
    }
}
