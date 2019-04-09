package com.baidu.swan.games.binding.model;

import android.util.Log;
import com.baidu.searchbox.v8engine.JsArrayBuffer;
import com.baidu.searchbox.v8engine.JsFunction;
import com.baidu.searchbox.v8engine.JsObject;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes2.dex */
public class c {
    private Map<String, Object> baX;
    private Map<String, Integer> baY;

    public static c b(JsObject jsObject) {
        if (jsObject == null) {
            Log.e("JSObjectMap", "parseFromJSObject object is null.");
            return null;
        }
        c cVar = new c();
        for (int i = 0; i < jsObject.length(); i++) {
            int propertyType = jsObject.getPropertyType(i);
            String propertyName = jsObject.getPropertyName(i);
            cVar.getTypeMap().put(propertyName, Integer.valueOf(propertyType));
            switch (propertyType) {
                case 1:
                    cVar.Nz().put(propertyName, Boolean.valueOf(jsObject.toBoolean(i)));
                    break;
                case 2:
                    cVar.Nz().put(propertyName, Integer.valueOf(jsObject.toInteger(i)));
                    break;
                case 3:
                    cVar.Nz().put(propertyName, Long.valueOf(jsObject.toLong(i)));
                    break;
                case 5:
                    cVar.Nz().put(propertyName, Double.valueOf(jsObject.toDouble(i)));
                    break;
                case 6:
                    cVar.Nz().put(propertyName, new d(i, jsObject));
                    break;
                case 7:
                    cVar.Nz().put(propertyName, jsObject.toString(i));
                    break;
                case 8:
                    cVar.Nz().put(propertyName, jsObject.toJsFunction(i));
                    break;
                case 9:
                    cVar.Nz().put(propertyName, jsObject.toJsObject(i));
                    break;
                case 10:
                    cVar.Nz().put(propertyName, jsObject.toJsArrayBuffer(i));
                    break;
            }
        }
        return cVar;
    }

    private Map<String, Object> Nz() {
        if (this.baX == null) {
            this.baX = new TreeMap();
        }
        return this.baX;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, Integer> getTypeMap() {
        if (this.baY == null) {
            this.baY = new TreeMap();
        }
        return this.baY;
    }

    /* renamed from: if  reason: not valid java name */
    public int m16if(String str) {
        Integer num = getTypeMap().get(str);
        if (num == null) {
            num = 12;
        }
        return num.intValue();
    }

    public int length() {
        return Nz().size();
    }

    public boolean optBoolean(String str) {
        return optBoolean(str, false);
    }

    public boolean optBoolean(String str, boolean z) {
        Boolean bool = a.toBoolean(Nz().get(str));
        return bool != null ? bool.booleanValue() : z;
    }

    public int getInt(String str) throws JSTypeMismatchException {
        Integer integer = a.toInteger(Nz().get(str));
        if (integer == null) {
            throw a.a(this, str, 2);
        }
        return integer.intValue();
    }

    public int optInt(String str) {
        return optInt(str, 0);
    }

    public int optInt(String str, int i) {
        Integer integer = a.toInteger(Nz().get(str));
        return integer != null ? integer.intValue() : i;
    }

    public String[] getStringArray(String str) throws JSTypeMismatchException {
        d M = a.M(Nz().get(str));
        if (M == null) {
            throw a.a(this, str, 6);
        }
        return M.baZ.toStringArray(M.index);
    }

    public String[] ig(String str) {
        return e(str, null);
    }

    public String[] e(String str, String[] strArr) {
        d M = a.M(Nz().get(str));
        return M != null ? M.baZ.toStringArray(M.index) : strArr;
    }

    public JsObject[] ih(String str) throws JSTypeMismatchException {
        d M = a.M(Nz().get(str));
        if (M == null) {
            throw a.a(this, str, 6);
        }
        return M.baZ.toObjectArray(M.index);
    }

    public String getString(String str) throws JSTypeMismatchException {
        String aVar = a.toString(Nz().get(str));
        if (aVar == null) {
            throw a.a(this, str, 7);
        }
        return aVar;
    }

    public String optString(String str) {
        return optString(str, "");
    }

    public String optString(String str, String str2) {
        String aVar = a.toString(Nz().get(str));
        return aVar != null ? aVar : str2;
    }

    public JsFunction ii(String str) {
        return a(str, (JsFunction) null);
    }

    public JsFunction a(String str, JsFunction jsFunction) {
        JsFunction N = a.N(Nz().get(str));
        return N != null ? N : jsFunction;
    }

    public JsObject ij(String str) {
        return a(str, (JsObject) null);
    }

    public JsObject a(String str, JsObject jsObject) {
        JsObject O = a.O(Nz().get(str));
        return O != null ? O : jsObject;
    }

    public JsArrayBuffer a(String str, JsArrayBuffer jsArrayBuffer) {
        JsArrayBuffer P = a.P(Nz().get(str));
        return P != null ? P : jsArrayBuffer;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a {
        static Boolean toBoolean(Object obj) {
            if (obj instanceof Boolean) {
                return (Boolean) obj;
            }
            return null;
        }

        static Integer toInteger(Object obj) {
            if (obj instanceof Integer) {
                return (Integer) obj;
            }
            if (obj instanceof Number) {
                return Integer.valueOf(((Number) obj).intValue());
            }
            return null;
        }

        static d M(Object obj) {
            if (obj instanceof d) {
                return (d) obj;
            }
            return null;
        }

        static String toString(Object obj) {
            if (obj instanceof String) {
                return (String) obj;
            }
            return null;
        }

        static JsFunction N(Object obj) {
            if (obj instanceof JsFunction) {
                return (JsFunction) obj;
            }
            return null;
        }

        static JsObject O(Object obj) {
            if (obj instanceof JsObject) {
                return (JsObject) obj;
            }
            return null;
        }

        static JsArrayBuffer P(Object obj) {
            if (obj instanceof JsArrayBuffer) {
                return (JsArrayBuffer) obj;
            }
            return null;
        }

        static JSTypeMismatchException a(c cVar, String str, int i) {
            int i2;
            if (cVar.getTypeMap().containsKey(str)) {
                i2 = ((Integer) cVar.getTypeMap().get(str)).intValue();
            } else {
                i2 = 12;
            }
            return new JSTypeMismatchException(str, i2, i, String.format("The \"%s\" argument must be %s. Received type %s", str, JsObject.typeToString(i), JsObject.typeToString(i2)));
        }
    }

    public String toString() {
        return Nz().toString();
    }
}
