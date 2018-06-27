package com.baidu.ar.msghandler;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.ar.util.Debug;
import com.baidu.baiduarsdk.filter.a.p;
import com.baidu.baiduarsdk.filter.a.q;
import com.baidu.baiduarsdk.filter.configdata.FilterData;
import com.baidu.baiduarsdk.filter.e;
import com.baidu.baiduarsdk.gpuimage.a.g;
import com.baidu.baiduarsdk.util.MsgParamsUtil;
import com.baidu.fsg.base.BaiduRimConstants;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.tencent.tauth.AuthActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c implements d {
    com.baidu.baiduarsdk.blend.b a;
    String b;

    public c(String str, com.baidu.baiduarsdk.blend.b bVar) {
        this.a = bVar;
        this.b = str;
        com.baidu.baiduarsdk.filter.e.a().a(this.b);
    }

    private static FilterData a(String str, Map<String, Object> map) {
        if (map == null || map.size() == 0) {
            return null;
        }
        String obj2String = MsgParamsUtil.obj2String(map.get("source_file"), null);
        String obj2String2 = MsgParamsUtil.obj2String(map.get("vertex_shader"), null);
        String obj2String3 = MsgParamsUtil.obj2String(map.get("fragment_shader"), null);
        FilterData filterData = new FilterData();
        filterData.a(MsgParamsUtil.obj2Int(map.get("pass_id"), -1));
        filterData.a(FilterData.PassType.a(MsgParamsUtil.obj2String(map.get("pass_type"), null)));
        filterData.a(FilterData.PassSubType.a(MsgParamsUtil.obj2String(map.get("sub_type"), null)));
        if (!TextUtils.isEmpty(obj2String)) {
            filterData.a(str != null ? str.concat(obj2String) : null);
        }
        if (!TextUtils.isEmpty(obj2String2)) {
            filterData.b(str != null ? str.concat(obj2String2) : null);
        }
        if (!TextUtils.isEmpty(obj2String3)) {
            filterData.c(str != null ? str.concat(obj2String3) : null);
        }
        try {
            String[] str2StringArray = MsgParamsUtil.str2StringArray(MsgParamsUtil.obj2String(map.get("multi_source_files"), null));
            if (str2StringArray != null && str2StringArray.length != 0) {
                ArrayList arrayList = new ArrayList();
                for (String str2 : str2StringArray) {
                    arrayList.add(str2);
                }
                filterData.a(arrayList);
            }
            filterData.a(new JSONObject(MsgParamsUtil.obj2HashMap(map.get(LegoListActivityConfig.PARAMS), null)));
            return filterData;
        } catch (Exception e) {
            e.printStackTrace();
            return filterData;
        }
    }

    private void a() {
        this.a.g();
    }

    private void a(int i, String str) {
        Debug.print("bdar:techniqueId = " + i);
        this.a.a(com.baidu.baiduarsdk.filter.e.a().a(i), str);
    }

    private void a(int i, String str, String str2) {
        com.baidu.baiduarsdk.filter.a a = com.baidu.baiduarsdk.filter.e.a().a(i);
        if (a == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        boolean z = str2.equals("0");
        if (str.equals("reality_target")) {
            a.b(z);
        } else if (str.equals("virtual_target")) {
            a.c(z);
        } else if (str.equals("mix_target")) {
            a.d(z);
        } else {
            a.a(z);
        }
    }

    private void a(int i, String str, Map<String, Object> map) {
        g a;
        Debug.print("bdar:techniqueId = " + i);
        com.baidu.baiduarsdk.filter.a a2 = com.baidu.baiduarsdk.filter.e.a().a(i);
        if (a2 != null) {
            FilterData a3 = a(a2.a(), map);
            int a4 = a3.a();
            q a5 = p.a(a3);
            if (a5 == null || (a = a5.a(a3)) == null || TextUtils.isEmpty(str)) {
                return;
            }
            if (str.equals("reality_target")) {
                if (a2.f() != null && a2.f().get(Integer.valueOf(a4)) != null) {
                    a2.a(a4, a3);
                    a2.a(a4, a);
                    return;
                }
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(a4), a3);
                HashMap hashMap2 = new HashMap();
                hashMap2.put(Integer.valueOf(a4), a);
                a2.a(hashMap);
                a2.d(hashMap2);
            } else if (str.equals("virtual_target")) {
                if (a2.g() != null && a2.g().get(Integer.valueOf(a4)) != null) {
                    a2.b(a4, a3);
                    a2.b(a4, a);
                    return;
                }
                HashMap hashMap3 = new HashMap();
                hashMap3.put(Integer.valueOf(a4), a3);
                HashMap hashMap4 = new HashMap();
                hashMap4.put(Integer.valueOf(a4), a);
                a2.b(hashMap3);
                a2.e(hashMap4);
            } else if (str.equals("mix_target")) {
                if (a2.h() != null && a2.h().get(Integer.valueOf(a4)) != null) {
                    a2.c(a4, a3);
                    a2.c(a4, a);
                    return;
                }
                HashMap hashMap5 = new HashMap();
                hashMap5.put(Integer.valueOf(a4), a3);
                HashMap hashMap6 = new HashMap();
                hashMap6.put(Integer.valueOf(a4), a);
                a2.c(hashMap5);
                a2.f(hashMap6);
            }
        }
    }

    private void a(String str) {
        com.baidu.baiduarsdk.filter.e.a().a(str, new e.a<com.baidu.baiduarsdk.filter.a>() { // from class: com.baidu.ar.msghandler.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.baiduarsdk.filter.e.a
            public void a(com.baidu.baiduarsdk.filter.a aVar) {
                if (aVar == null || c.this.a == null) {
                    return;
                }
                c.this.a.a(aVar, (String) null);
            }
        });
    }

    private void a(String str, int i, Map<String, Object> map) {
        FilterData filterData;
        g gVar = null;
        com.baidu.baiduarsdk.filter.a h = this.a.h();
        if (h == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (str.equals("reality_target")) {
            if (h.f() != null && h.i() != null) {
                filterData = h.f().get(Integer.valueOf(i));
                gVar = h.i().get(Integer.valueOf(i));
            }
            filterData = null;
        } else if (str.equals("virtual_target")) {
            if (h.g() != null && h.j() != null) {
                filterData = h.g().get(Integer.valueOf(i));
                gVar = h.j().get(Integer.valueOf(i));
            }
            filterData = null;
        } else {
            if (str.equals("mix_target") && h.h() != null && h.k() != null) {
                filterData = h.h().get(Integer.valueOf(i));
                gVar = h.k().get(Integer.valueOf(i));
            }
            filterData = null;
        }
        if (filterData == null || gVar == null) {
            return;
        }
        p.a(filterData).a(gVar, map);
    }

    private void b(int i, String str) {
        com.baidu.baiduarsdk.filter.a a = com.baidu.baiduarsdk.filter.e.a().a(i);
        if (a == null || TextUtils.isEmpty(str)) {
            return;
        }
        a.a(str.equals("0"));
    }

    private void b(int i, String str, Map<String, Object> map) {
        g a;
        g a2;
        g a3;
        Debug.print("bdar:techniqueId = " + i);
        com.baidu.baiduarsdk.filter.a a4 = com.baidu.baiduarsdk.filter.e.a().a(i);
        if (a4 != null) {
            FilterData a5 = a(a4.a(), map);
            int a6 = a5.a();
            q a7 = p.a(a5);
            if (a7 == null || TextUtils.isEmpty(str)) {
                return;
            }
            if (str.equals("reality_target")) {
                if (a4.f() == null || a4.f().get(Integer.valueOf(a6)) != null || (a3 = a7.a(a5)) == null) {
                    return;
                }
                a4.a(a6, a5);
                a4.a(a6, a3);
            } else if (str.equals("virtual_target")) {
                if (a4.g() == null || a4.g().get(Integer.valueOf(a6)) != null || (a2 = a7.a(a5)) == null) {
                    return;
                }
                a4.b(a6, a5);
                a4.b(a6, a2);
            } else if (!str.equals("mix_target") || a4.h() == null || a4.h().get(Integer.valueOf(a6)) != null || (a = a7.a(a5)) == null) {
            } else {
                a4.c(a6, a5);
                a4.c(a6, a);
            }
        }
    }

    private void c(int i, String str, Map<String, Object> map) {
        Debug.print("bdar:techniqueId = " + i);
        com.baidu.baiduarsdk.filter.a a = com.baidu.baiduarsdk.filter.e.a().a(i);
        if (a != null) {
            int a2 = a(a.a(), map).a();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (str.equals("reality_target")) {
                a.b(a2);
                a.e(a2);
            } else if (str.equals("virtual_target")) {
                a.c(a2);
                a.f(a2);
            } else if (str.equals("mix_target")) {
                a.d(a2);
                a.g(a2);
            }
        }
    }

    @Override // com.baidu.ar.msghandler.d
    public void parseComponentData(HashMap<String, Object> hashMap) {
        if (hashMap != null) {
            int obj2Int = MsgParamsUtil.obj2Int(hashMap.get(AuthActivity.ACTION_KEY), -1);
            Log.e("lua  ", " ArBridge.LuaSdkBridgeMessageType = " + obj2Int);
            try {
                switch (obj2Int) {
                    case ComponentMessageType.MSG_TYPE_FILTER_START /* 1065 */:
                        a(MsgParamsUtil.obj2String(hashMap.get("file_path"), null));
                        break;
                    case 1066:
                    case 1068:
                    case 1070:
                    default:
                        return;
                    case ComponentMessageType.MSG_TYPE_FILTER_STOP /* 1067 */:
                        a();
                        break;
                    case ComponentMessageType.MSG_TYPE_FILTER_UPDATE /* 1069 */:
                        a(Integer.valueOf(MsgParamsUtil.obj2String(hashMap.get("filter_group_id"), "-1")).intValue(), (String) null);
                        break;
                    case ComponentMessageType.MSG_TYPE_FILTER_DISABLE_TECHNIQUE /* 1071 */:
                        b(Integer.valueOf(MsgParamsUtil.obj2String(hashMap.get("filter_group_id"), "-1")).intValue(), MsgParamsUtil.obj2String(hashMap.get("disable"), "0"));
                        break;
                    case ComponentMessageType.MSG_TYPE_FILTER_RESET /* 1072 */:
                        switch (FilterData.ResetType.a(MsgParamsUtil.obj2Int(hashMap.get("reset_type"), -1))) {
                            case UPDATE:
                                a(Integer.valueOf(MsgParamsUtil.obj2String(hashMap.get("filter_group_id"), "-1")).intValue(), MsgParamsUtil.obj2String(hashMap.get(BaiduRimConstants.ACTION_TARGET), null), MsgParamsUtil.obj2HashMap(hashMap.get("pass"), null));
                                break;
                            case ADD:
                                b(Integer.valueOf(MsgParamsUtil.obj2String(hashMap.get("filter_group_id"), "-1")).intValue(), MsgParamsUtil.obj2String(hashMap.get(BaiduRimConstants.ACTION_TARGET), null), MsgParamsUtil.obj2HashMap(hashMap.get("pass"), null));
                                break;
                            case DELETE:
                                c(Integer.valueOf(MsgParamsUtil.obj2String(hashMap.get("filter_group_id"), "-1")).intValue(), MsgParamsUtil.obj2String(hashMap.get(BaiduRimConstants.ACTION_TARGET), null), MsgParamsUtil.obj2HashMap(hashMap.get("pass"), null));
                                break;
                        }
                    case ComponentMessageType.MSG_TYPE_FILTER_DISABLE_TARGET /* 1073 */:
                        a(Integer.valueOf(MsgParamsUtil.obj2String(hashMap.get("filter_group_id"), "-1")).intValue(), MsgParamsUtil.obj2String(hashMap.get(BaiduRimConstants.ACTION_TARGET), null), MsgParamsUtil.obj2String(hashMap.get("disable"), "0"));
                        break;
                    case ComponentMessageType.MSG_TYPE_FILTER_ADJUST /* 1074 */:
                        a(MsgParamsUtil.obj2String(hashMap.get(BaiduRimConstants.ACTION_TARGET), null), Integer.valueOf(MsgParamsUtil.obj2String(hashMap.get("pass_id"), "-1")).intValue(), MsgParamsUtil.obj2HashMap(hashMap.get("adjust_params"), null));
                        break;
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.ar.msghandler.d
    public void release() {
        com.baidu.baiduarsdk.filter.e.a().c();
        com.baidu.baiduarsdk.filter.e.b();
        this.a = null;
    }
}
