package com.baidu.ar.face;

import android.graphics.PointF;
import android.text.TextUtils;
import com.baidu.ala.dumixar.utils.LuaMessageHelper;
import com.baidu.ar.face.a.h;
import com.baidu.ar.face.algo.FAUFaceBox;
import com.baidu.ar.face.algo.FAUPoint2D;
import com.baidu.ar.face.algo.FaceFrame;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {
    public static int B(int i) {
        switch (i) {
            case -90:
                return 3;
            case 0:
                return 0;
            case 90:
                return 1;
            case 180:
                return 2;
            default:
                return -1;
        }
    }

    public static int a(String str, String str2, String str3, String str4) {
        if (TextUtils.isEmpty(str) || str.equals(str4)) {
            return 0;
        }
        if (str.equals(str3)) {
            return 1;
        }
        return str.equals(str2) ? 2 : 0;
    }

    public static boolean a(String str, String str2, String str3, String[] strArr, String str4, String str5, String str6, String str7) {
        if (str == null) {
            com.baidu.ar.f.b.b("bdar-face", "error: imbinModelPath is null!");
            return true;
        } else if (str2 == null) {
            com.baidu.ar.f.b.b("bdar-face", "error: detectModelPath is null!");
            return true;
        } else if (str3 == null) {
            com.baidu.ar.f.b.b("bdar-face", "error: trackPath0 is null!");
            return true;
        } else if (strArr == null || strArr.length < 3) {
            com.baidu.ar.f.b.b("bdar-face", "error: trackPath1 is null, or length < 3!");
            return true;
        } else if (str4 == null) {
            com.baidu.ar.f.b.b("bdar-face", "error: trackPath2 is null!");
            return true;
        } else if (str5 == null) {
            com.baidu.ar.f.b.b("bdar-face", "error: trackPath3 is null!");
            return true;
        } else if (str6 == null) {
            com.baidu.ar.f.b.b("bdar-face", "error: expressionModelPath is null!");
            return true;
        } else if (str7 == null) {
            com.baidu.ar.f.b.b("bdar-face", "error: mouthModelPath is null!");
            return true;
        } else {
            return false;
        }
    }

    public static int[] a(int[] iArr, int[] iArr2) {
        int[] iArr3;
        boolean z;
        if (iArr == null || iArr.length == 0) {
            return iArr2;
        }
        if (iArr2 == null || iArr2.length == 0) {
            return iArr;
        }
        if (iArr.length > iArr2.length) {
            iArr3 = iArr;
        } else if (iArr.length < iArr2.length) {
            iArr3 = iArr2;
            iArr2 = iArr;
        } else {
            iArr2 = null;
            iArr3 = null;
        }
        if (iArr3 == null || iArr2 == null) {
            return null;
        }
        int[] iArr4 = new int[iArr3.length - iArr2.length];
        int i = 0;
        for (int i2 = 0; i2 < iArr3.length; i2++) {
            int i3 = 0;
            while (true) {
                if (i3 >= iArr2.length) {
                    z = false;
                    break;
                } else if (iArr3[i2] == iArr2[i3]) {
                    z = true;
                    break;
                } else {
                    i3++;
                }
            }
            if (!z) {
                iArr4[i] = iArr3[i2];
                i++;
            }
        }
        return iArr4;
    }

    public static int b(String str, int i) {
        try {
            int i2 = new JSONObject(str).getInt("maxFaceSupport");
            if (i2 <= 1) {
                return 1;
            }
            return i2;
        } catch (JSONException e) {
            e.printStackTrace();
            return i;
        }
    }

    public static boolean b(String str, boolean z) {
        try {
            String string = new JSONObject(str).getString("assetAttributes");
            if (TextUtils.isEmpty(string)) {
                return true;
            }
            return new JSONObject(string).getBoolean("needHeadPose");
        } catch (JSONException e) {
            e.printStackTrace();
            return z;
        }
    }

    public static FaceResultData c(h hVar) {
        FaceResultData faceResultData = new FaceResultData();
        faceResultData.setTimestamp(hVar.getTimestamp());
        faceResultData.setTracked(hVar.isTracked());
        faceResultData.setFrontCamera(hVar.isFrontCamera());
        if (hVar.dc() != null && hVar.dc().getFaceFrame() != null) {
            FaceFrame faceFrame = hVar.dc().getFaceFrame();
            if (faceFrame.getFaceBoxes() != null && faceFrame.getFaceBoxes().size() > 0) {
                List<FAUFaceBox> faceBoxes = faceFrame.getFaceBoxes();
                float[] fArr = new float[faceBoxes.size() * 4];
                for (int i = 0; i < faceBoxes.size(); i++) {
                    FAUFaceBox fAUFaceBox = faceBoxes.get(i);
                    fArr[i * 4] = fAUFaceBox.getX();
                    fArr[(i * 4) + 1] = fAUFaceBox.getY();
                    fArr[(i * 4) + 2] = fAUFaceBox.getWidth();
                    fArr[(i * 4) + 3] = fAUFaceBox.getHeight();
                }
                faceResultData.setFaceBoxes(fArr);
            }
            List<FAUPoint2D[]> trackedPointsList = faceFrame.getTrackedPointsList();
            if (trackedPointsList != null && trackedPointsList.size() > 0 && trackedPointsList.get(0) != null) {
                ArrayList<PointF> arrayList = new ArrayList<PointF>() { // from class: com.baidu.ar.face.b.1
                };
                for (FAUPoint2D[] fAUPoint2DArr : trackedPointsList) {
                    for (FAUPoint2D fAUPoint2D : fAUPoint2DArr) {
                        arrayList.add(new PointF(fAUPoint2D.getX(), fAUPoint2D.getY()));
                    }
                }
                faceResultData.setFacePoints(arrayList);
            }
            faceResultData.setTriggers(faceFrame.getTriggersList());
            if (faceFrame.getHeadPoses() != null) {
                faceResultData.setHeadPoses(new ArrayList(faceFrame.getHeadPoses()));
            }
        }
        return faceResultData;
    }

    public static boolean c(String str, boolean z) {
        try {
            String string = new JSONObject(str).getString("assetAttributes");
            if (TextUtils.isEmpty(string)) {
                return true;
            }
            return new JSONObject(string).getBoolean("needSkeleton");
        } catch (JSONException e) {
            e.printStackTrace();
            return z;
        }
    }

    public static boolean d(String str, boolean z) {
        try {
            String string = new JSONObject(str).getString("assetAttributes");
            if (TextUtils.isEmpty(string)) {
                return true;
            }
            return new JSONObject(string).getBoolean("needTriggers");
        } catch (JSONException e) {
            e.printStackTrace();
            return z;
        }
    }

    public static boolean e(String str, boolean z) {
        try {
            String string = new JSONObject(str).getString("assetAttributes");
            if (TextUtils.isEmpty(string)) {
                return false;
            }
            return new JSONObject(string).getBoolean("needExpression");
        } catch (JSONException e) {
            e.printStackTrace();
            return z;
        }
    }

    public static boolean f(String str, boolean z) {
        try {
            String string = new JSONObject(str).getString("assetAttributes");
            if (TextUtils.isEmpty(string)) {
                return false;
            }
            return new JSONObject(string).getBoolean("needDumoji");
        } catch (JSONException e) {
            e.printStackTrace();
            return z;
        }
    }

    public static boolean g(String str, boolean z) {
        try {
            String string = new JSONObject(str).getString("assetAttributes");
            if (TextUtils.isEmpty(string)) {
                return true;
            }
            return new JSONObject(string).getBoolean("needRefineEyes");
        } catch (JSONException e) {
            e.printStackTrace();
            return z;
        }
    }

    public static int k(HashMap<String, Object> hashMap) {
        String str = (String) hashMap.get("ability_name");
        String str2 = (String) hashMap.get("param_name");
        if ("ability_operation".equals((String) hashMap.get(LuaMessageHelper.KEY_EVENT_NAME)) && "ability_face_model".equals(str)) {
            com.baidu.ar.f.b.aK("bdar-face lua message:" + hashMap.toString());
            if ("face_model".equals(str2)) {
                String str3 = (String) hashMap.get("param_value");
                if ("v3".equals(str3) || "model_for_makeup".equals(str3)) {
                    com.baidu.ar.face.a.a.cT().C(2);
                    com.baidu.ar.face.a.a.cT().a(0.01f, 1.0f);
                    com.baidu.ar.face.a.a.cT().e(0.1f);
                    return 2;
                } else if ("v6".equals(str3)) {
                    com.baidu.ar.face.a.a.cT().C(0);
                    com.baidu.ar.face.a.a.cT().a(0.01f, 1.0f);
                    com.baidu.ar.face.a.a.cT().e(0.1f);
                    return 0;
                }
            } else if ("need_refine_eyes".equals(str2)) {
                com.baidu.ar.face.a.a.cT().y(((Float) hashMap.get("param_value")).floatValue() == 1.0f);
            } else if ("need_refine_mouth".equals(str2)) {
                com.baidu.ar.face.a.a.cT().A(((Float) hashMap.get("param_value")).floatValue() == 1.0f);
            } else if ("need_head_pose".equals(str2)) {
                com.baidu.ar.face.a.a.cT().setNeedHeadPose(((Float) hashMap.get("param_value")).floatValue() == 1.0f);
            } else if ("need_skeleton".equals(str2)) {
                com.baidu.ar.face.a.a.cT().setNeedSkeleton(((Float) hashMap.get("param_value")).floatValue() == 1.0f);
            } else if ("need_triggers".equals(str2)) {
                com.baidu.ar.face.a.a.cT().setNeedTriggers(((Float) hashMap.get("param_value")).floatValue() == 1.0f);
            } else if ("need_expression".equals(str2)) {
                com.baidu.ar.face.a.a.cT().B(((Float) hashMap.get("param_value")).floatValue() == 1.0f);
            } else if ("need_dumoji".equals(str2)) {
                com.baidu.ar.face.a.a.cT().z(((Float) hashMap.get("param_value")).floatValue() == 1.0f);
            } else if ("prefer_max_face_count".equals(str2)) {
                com.baidu.ar.face.a.a.cT().D((int) ((Float) hashMap.get("param_value")).floatValue());
            }
        }
        return -1;
    }
}
