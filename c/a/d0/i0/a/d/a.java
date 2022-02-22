package c.a.d0.i0.a.d;

import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import c.a.d0.v.d;
import c.a.d0.v.v0.h;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideo;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.nadcore.video.plugin.videoplayer.model.ClarityUrlList;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2060589310, "Lc/a/d0/i0/a/d/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2060589310, "Lc/a/d0/i0/a/d/a;");
                return;
            }
        }
        a = d.f();
    }

    public static String a(JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONArray)) == null) {
            if (jSONArray == null) {
                return null;
            }
            try {
                SparseArray sparseArray = new SparseArray();
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                    sparseArray.put(jSONObject.optInt("rank"), jSONObject.optString("url"));
                }
                if (sparseArray.size() > 0) {
                    return (String) sparseArray.valueAt(0);
                }
                return null;
            } catch (JSONException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x041b  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x042c  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0436  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0441  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x03ee A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0498 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:140:0x02bd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x02da  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0302  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x031a  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x032b  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x033c  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x035f  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0361  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0368  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x036a  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0374  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0387  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0389  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0398  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x03b2  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x03b4  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x03c3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static BdVideoSeries b(HashMap<Integer, String> hashMap) {
        InterceptResult invokeL;
        boolean z;
        String str;
        ClarityUrlList clarityList;
        String str2;
        String str3;
        String str4;
        String str5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, hashMap)) == null) {
            if (hashMap == null || hashMap.size() == 0) {
                return null;
            }
            BdVideoSeries bdVideoSeries = new BdVideoSeries();
            String str6 = hashMap.get(0);
            String str7 = hashMap.get(5);
            String str8 = hashMap.get(1);
            String str9 = hashMap.get(3);
            String str10 = hashMap.get(9);
            String str11 = hashMap.get(6);
            String str12 = hashMap.get(7);
            String str13 = hashMap.get(16);
            try {
                z = Boolean.parseBoolean(hashMap.get(17));
            } catch (Exception e2) {
                h.b("BdVideoNewParser", Log.getStackTraceString(e2));
                z = false;
            }
            String str14 = hashMap.get(105);
            String str15 = hashMap.get(106);
            String str16 = hashMap.get(107);
            String str17 = hashMap.get(108);
            String str18 = hashMap.get(109);
            String str19 = hashMap.get(110);
            String str20 = hashMap.get(112);
            boolean z2 = z;
            String str21 = hashMap.get(111);
            String str22 = hashMap.get(113);
            String str23 = hashMap.get(114);
            String str24 = hashMap.get(115);
            String str25 = hashMap.get(120);
            String str26 = hashMap.get(121);
            String str27 = hashMap.get(122);
            String str28 = hashMap.get(123);
            String str29 = hashMap.get(124);
            String str30 = hashMap.get(125);
            String str31 = hashMap.get(305);
            String str32 = hashMap.get(301);
            String str33 = hashMap.get(302);
            String str34 = hashMap.get(127);
            String str35 = hashMap.get(304);
            String str36 = hashMap.get(305);
            bdVideoSeries.setMPD(hashMap.get(350));
            bdVideoSeries.setMPDUrl(hashMap.get(351));
            bdVideoSeries.setMPDVid(hashMap.get(352));
            String str37 = hashMap.get(353);
            String str38 = hashMap.get(103);
            int c2 = str38 != null ? c.a.d0.v.v0.d.c(str38) : 101;
            bdVideoSeries.setFrom(str32);
            bdVideoSeries.setPage(str29);
            if (!TextUtils.isEmpty(bdVideoSeries.getMPD())) {
                bdVideoSeries.setClarityUrlList(bdVideoSeries.getMPD(), true);
                bdVideoSeries.setHasDecodedMPD(true);
            } else {
                String str39 = hashMap.get(303);
                if (!TextUtils.isEmpty(str39)) {
                    bdVideoSeries.setClarityUrlList(str39);
                }
            }
            if (!TextUtils.isEmpty(str17)) {
                try {
                    JSONObject jSONObject = new JSONObject(str17);
                    String optString = jSONObject.optString("preview_6s_url");
                    bdVideoSeries.setShareMode(jSONObject.optJSONObject("share"));
                    bdVideoSeries.setPreview6sUrl(optString);
                    if (bdVideoSeries.getClarityList() == null) {
                        bdVideoSeries.setClarityUrlList(jSONObject.optString("clarityUrl"));
                    }
                    try {
                        String optString2 = jSONObject.optString("longVideo", null);
                        if (optString2 != null) {
                            bdVideoSeries.setLongVideo(new JSONObject(optString2).optString("cmd", null));
                        } else {
                            str = null;
                            try {
                                bdVideoSeries.setLongVideo(null);
                            } catch (JSONException e3) {
                                e = e3;
                                bdVideoSeries.setLongVideo(str);
                                h.b("BdVideoNewParser", Log.getStackTraceString(e));
                                if (!TextUtils.isEmpty(str21)) {
                                }
                                clarityList = bdVideoSeries.getClarityList();
                                if (clarityList == null) {
                                }
                                StringBuilder sb = new StringBuilder();
                                if (!TextUtils.isEmpty(str9)) {
                                }
                                if (!TextUtils.isEmpty(str10)) {
                                }
                                if (!TextUtils.isEmpty(str12)) {
                                }
                                int parseDoubleSafe = (int) BdVideoSeries.parseDoubleSafe(str31, -1.0d);
                                bdVideoSeries.setStartPosition(parseDoubleSafe);
                                bdVideoSeries.setDuration(BdVideoSeries.parseIntSafe(str20, 0));
                                bdVideoSeries.setHttpHeader(sb.toString());
                                bdVideoSeries.setProxy(str11);
                                bdVideoSeries.setRecommendList(str14 != null ? "" : str14);
                                bdVideoSeries.setPoster(str16 != null ? "" : str16);
                                bdVideoSeries.setExt(str17);
                                if (str21 == null) {
                                }
                                bdVideoSeries.setExtLog(str21);
                                bdVideoSeries.setNetToast(!TextUtils.equals(str18, "0"));
                                bdVideoSeries.setVid(str22 != null ? "" : str22);
                                if (!TextUtils.isEmpty(bdVideoSeries.getVid())) {
                                }
                                bdVideoSeries.setFormat(str23 != null ? "" : str23);
                                if (TextUtils.equals(str24, "1")) {
                                }
                                bdVideoSeries.setVideoFaceDetect(str33);
                                bdVideoSeries.setFloatingDisable(str36);
                                bdVideoSeries.setUrlExpireTime(str34);
                                BdVideo bdVideo = new BdVideo();
                                Map<String, String> e4 = e(str6);
                                str2 = e4.get("title");
                                if (!TextUtils.isEmpty(str2)) {
                                }
                                str3 = e4.get("pageUrl");
                                str4 = e4.get("show_title");
                                str5 = e4.get("show_share");
                                if (TextUtils.isEmpty(str2)) {
                                }
                                bdVideo.setTitle(str2);
                                bdVideo.setVideoId(str22);
                                if (!TextUtils.isEmpty(str3)) {
                                }
                                bdVideo.setSourceUrl(str7);
                                if (TextUtils.isEmpty(str4)) {
                                }
                                bdVideo.setShowTitle(str4);
                                if (TextUtils.isEmpty(str5)) {
                                }
                                bdVideo.setShowShare(str5);
                                bdVideo.setCurrentLength(parseDoubleSafe + "");
                                bdVideo.setPlayUrl(str6);
                                bdVideo.setType(c2);
                                bdVideo.setTotalLength(str20);
                                ArrayList arrayList = new ArrayList();
                                arrayList.add(bdVideo);
                                bdVideoSeries.setTitle(str8);
                                bdVideoSeries.setVideoList(arrayList);
                                bdVideoSeries.setSelectedIndex(0);
                                bdVideoSeries.setAnimLogoEnable("1".equals(str25));
                                bdVideoSeries.setAnimLogoJumpScheme(str26);
                                bdVideoSeries.setAnimLogoDownloadScheme(str27);
                                bdVideoSeries.setAnimLogoDownloadToast(str28);
                                bdVideoSeries.setWebPlayerExt(str13);
                                if (!TextUtils.isEmpty(str30)) {
                                }
                                bdVideoSeries.setPlayConf(str35);
                                bdVideoSeries.setResourceType(str37);
                                bdVideoSeries.setStartOnPreparedEnable(z2);
                                return bdVideoSeries;
                            }
                        }
                    } catch (JSONException e5) {
                        e = e5;
                        str = null;
                    }
                } catch (JSONException e6) {
                    e = e6;
                    str = null;
                }
            }
            if (!TextUtils.isEmpty(str21)) {
                try {
                    bdVideoSeries.setPd(new JSONObject(str21).optString("pd"));
                } catch (JSONException e7) {
                    h.b("BdVideoNewParser", Log.getStackTraceString(e7));
                }
            }
            clarityList = bdVideoSeries.getClarityList();
            if (clarityList == null) {
                ClarityUrlList.c currentClarityUrl = clarityList.getCurrentClarityUrl();
                if (currentClarityUrl != null) {
                    bdVideoSeries.setVideoBps(currentClarityUrl.h());
                    bdVideoSeries.setMoovSize(currentClarityUrl.d());
                    if (TextUtils.isEmpty(str10)) {
                        str10 = c.a.d0.v.y.c.b.a.c(currentClarityUrl.b(), currentClarityUrl.g(), str7);
                    }
                }
            } else if (TextUtils.isEmpty(str10)) {
                str10 = c.a.d0.v.y.c.b.a.c(null, str6, str7);
            }
            StringBuilder sb2 = new StringBuilder();
            if (!TextUtils.isEmpty(str9)) {
                sb2.append("Cookie:");
                sb2.append(str9);
                sb2.append("\r\n");
            }
            if (!TextUtils.isEmpty(str10)) {
                sb2.append("Referer:");
                sb2.append(str10);
                sb2.append("\r\n");
            }
            if (!TextUtils.isEmpty(str12)) {
                sb2.append(str12);
            }
            int parseDoubleSafe2 = (int) BdVideoSeries.parseDoubleSafe(str31, -1.0d);
            bdVideoSeries.setStartPosition(parseDoubleSafe2);
            bdVideoSeries.setDuration(BdVideoSeries.parseIntSafe(str20, 0));
            bdVideoSeries.setHttpHeader(sb2.toString());
            bdVideoSeries.setProxy(str11);
            bdVideoSeries.setRecommendList(str14 != null ? "" : str14);
            bdVideoSeries.setPoster(str16 != null ? "" : str16);
            bdVideoSeries.setExt(str17);
            if (str21 == null) {
                str21 = "";
            }
            bdVideoSeries.setExtLog(str21);
            bdVideoSeries.setNetToast(!TextUtils.equals(str18, "0"));
            bdVideoSeries.setVid(str22 != null ? "" : str22);
            if (!TextUtils.isEmpty(bdVideoSeries.getVid())) {
                bdVideoSeries.setNid("sv_" + bdVideoSeries.getVid());
            }
            bdVideoSeries.setFormat(str23 != null ? "" : str23);
            if (TextUtils.equals(str24, "1")) {
                bdVideoSeries.setPlayLoop(true);
            }
            bdVideoSeries.setVideoFaceDetect(str33);
            bdVideoSeries.setFloatingDisable(str36);
            bdVideoSeries.setUrlExpireTime(str34);
            BdVideo bdVideo2 = new BdVideo();
            Map<String, String> e42 = e(str6);
            str2 = e42.get("title");
            if (!TextUtils.isEmpty(str2)) {
                try {
                    str2 = URLDecoder.decode(str2, "UTF-8");
                } catch (UnsupportedEncodingException e8) {
                    h.b("BdVideoNewParser", Log.getStackTraceString(e8));
                }
            }
            str3 = e42.get("pageUrl");
            str4 = e42.get("show_title");
            str5 = e42.get("show_share");
            if (TextUtils.isEmpty(str2)) {
                str2 = str8;
            }
            bdVideo2.setTitle(str2);
            bdVideo2.setVideoId(str22);
            if (!TextUtils.isEmpty(str3)) {
                str7 = str3;
            }
            bdVideo2.setSourceUrl(str7);
            if (TextUtils.isEmpty(str4)) {
                str4 = str15;
            }
            bdVideo2.setShowTitle(str4);
            if (TextUtils.isEmpty(str5)) {
                str5 = str19;
            }
            bdVideo2.setShowShare(str5);
            bdVideo2.setCurrentLength(parseDoubleSafe2 + "");
            bdVideo2.setPlayUrl(str6);
            bdVideo2.setType(c2);
            bdVideo2.setTotalLength(str20);
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(bdVideo2);
            bdVideoSeries.setTitle(str8);
            bdVideoSeries.setVideoList(arrayList2);
            bdVideoSeries.setSelectedIndex(0);
            bdVideoSeries.setAnimLogoEnable("1".equals(str25));
            bdVideoSeries.setAnimLogoJumpScheme(str26);
            bdVideoSeries.setAnimLogoDownloadScheme(str27);
            bdVideoSeries.setAnimLogoDownloadToast(str28);
            bdVideoSeries.setWebPlayerExt(str13);
            if (!TextUtils.isEmpty(str30)) {
                try {
                    bdVideoSeries.setHotCommentList(c.a.d0.v.m0.d.b(new JSONArray(str30)));
                } catch (Exception e9) {
                    e9.printStackTrace();
                }
            }
            bdVideoSeries.setPlayConf(str35);
            bdVideoSeries.setResourceType(str37);
            bdVideoSeries.setStartOnPreparedEnable(z2);
            return bdVideoSeries;
        }
        return (BdVideoSeries) invokeL.objValue;
    }

    public static BdVideoSeries c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? d(f(str)) : (BdVideoSeries) invokeL.objValue;
    }

    public static BdVideoSeries d(HashMap<Integer, String> hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, hashMap)) == null) {
            BdVideoSeries b2 = b(hashMap);
            if (b2 == null) {
                return null;
            }
            String str = hashMap.get(0);
            String str2 = hashMap.get(303);
            ClarityUrlList clarityList = b2.getClarityList();
            if (TextUtils.isEmpty(str) && clarityList != null) {
                str = clarityList.getDefaultUrl();
            }
            if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                try {
                    str = a(new JSONArray(str2));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            String str3 = hashMap.get(108);
            if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(str3)) {
                try {
                    str = a(new JSONObject(str3).getJSONArray("clarityUrl"));
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
            if (b2.getSelectedVideo() != null) {
                b2.getSelectedVideo().setPlayUrl(str);
            }
            return b2;
        }
        return (BdVideoSeries) invokeL.objValue;
    }

    public static Map<String, String> e(String str) {
        InterceptResult invokeL;
        int indexOf;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            HashMap hashMap = new HashMap();
            if (str != null && (indexOf = str.indexOf("#") + 1) > 0) {
                for (String str2 : str.substring(indexOf).split("#")) {
                    int indexOf2 = str2.indexOf("=");
                    if (indexOf2 >= 0) {
                        hashMap.put(str2.substring(0, indexOf2), str2.substring(indexOf2 + 1));
                    }
                }
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public static HashMap<Integer, String> f(String str) {
        InterceptResult invokeL;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            HashMap<Integer, String> hashMap = new HashMap<>();
            try {
                JSONObject jSONObject2 = new JSONObject(str);
                hashMap.put(0, jSONObject2.optString("videoUrl"));
                hashMap.put(106, "false");
                hashMap.put(1, jSONObject2.optString("title"));
                hashMap.put(110, "true");
                hashMap.put(124, jSONObject2.optString("page"));
                String optString = jSONObject2.optString("ext_log");
                if (!TextUtils.isEmpty(optString)) {
                    jSONObject = new JSONObject(optString);
                } else {
                    jSONObject = new JSONObject();
                }
                jSONObject.put("ext_page", jSONObject2.optString("page"));
                hashMap.put(111, jSONObject.toString());
                hashMap.put(108, jSONObject2.optString("ext"));
                hashMap.put(5, jSONObject2.optString("pageUrl"));
                hashMap.put(107, jSONObject2.optString("posterImage"));
                hashMap.put(112, jSONObject2.optString("duration"));
                hashMap.put(113, jSONObject2.optString(TiebaStatic.Params.VID));
                hashMap.put(103, "3");
                JSONObject optJSONObject = jSONObject2.optJSONObject("playerAnimation");
                if (optJSONObject != null) {
                    boolean equals = "1".equals(optJSONObject.optString("playerAnimationFlag"));
                    String optString2 = optJSONObject.optString("animationJumpScheme");
                    String optString3 = optJSONObject.optString("animationDownloadScheme");
                    String optString4 = optJSONObject.optString("downloadToast");
                    if (equals) {
                        hashMap.put(120, "1");
                        hashMap.put(121, optString2);
                        hashMap.put(122, optString3);
                        hashMap.put(123, optString4);
                    }
                }
                hashMap.put(105, jSONObject2.optString("recommend_list"));
                hashMap.put(301, jSONObject2.optString("from"));
                hashMap.put(305, jSONObject2.optString("seekSeconds"));
                hashMap.put(302, jSONObject2.optString("hasFaceDetect"));
                hashMap.put(127, String.valueOf(jSONObject2.optInt("urlExpireTs")));
                String optString5 = jSONObject2.optString("clarityUrl");
                if (!TextUtils.isEmpty(optString5)) {
                    hashMap.put(303, optString5);
                }
                String optString6 = jSONObject2.optString("play_conf");
                if (!TextUtils.isEmpty(optString6)) {
                    hashMap.put(304, optString6);
                }
                String optString7 = jSONObject2.optString("play_floating_conf");
                if (!TextUtils.isEmpty(optString7)) {
                    hashMap.put(305, optString7);
                }
                hashMap.put(350, jSONObject2.optString("mpd"));
                hashMap.put(351, jSONObject2.optString("mpd_url"));
                hashMap.put(352, jSONObject2.optString("mpd_vid"));
                hashMap.put(353, jSONObject2.optString("resourceType"));
            } catch (Exception e2) {
                if (a) {
                    e2.printStackTrace();
                }
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }
}
