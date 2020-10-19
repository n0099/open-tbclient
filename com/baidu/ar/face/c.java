package com.baidu.ar.face;

import android.graphics.PointF;
import android.text.TextUtils;
import com.baidu.ala.dumixar.utils.LuaMessageHelper;
import com.baidu.ar.face.algo.FAUFaceBox;
import com.baidu.ar.face.algo.FAUPoint2D;
import com.baidu.ar.face.algo.FaceAlgoData;
import com.baidu.ar.face.algo.FaceFrame;
import com.baidu.ar.face.detector.i;
import com.baidu.ar.face.detector.m;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes14.dex */
public class c {
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

    public static int a(HashMap<String, Object> hashMap, i iVar) {
        String str = (String) hashMap.get("ability_name");
        String str2 = (String) hashMap.get("param_name");
        if ("ability_operation".equals((String) hashMap.get(LuaMessageHelper.KEY_EVENT_NAME)) && "ability_face_model".equals(str)) {
            com.baidu.ar.g.b.aO("bdar-face lua message:" + hashMap.toString());
            if ("face_model".equals(str2)) {
                String str3 = (String) hashMap.get("param_value");
                if ("v3".equals(str3) || "model_for_makeup".equals(str3)) {
                    iVar.E(2);
                    iVar.a(0.01f, 1.0f);
                    iVar.e(0.1f);
                    return 2;
                } else if ("v6".equals(str3)) {
                    iVar.E(0);
                    iVar.a(0.01f, 1.0f);
                    iVar.e(0.1f);
                    return 0;
                }
            } else if ("need_refine_eyes".equals(str2)) {
                iVar.B(((Float) hashMap.get("param_value")).floatValue() == 1.0f);
            } else if ("need_refine_mouth".equals(str2)) {
                iVar.D(((Float) hashMap.get("param_value")).floatValue() == 1.0f);
            } else if ("need_head_pose".equals(str2)) {
                iVar.setNeedHeadPose(((Float) hashMap.get("param_value")).floatValue() == 1.0f);
            } else if ("need_skeleton".equals(str2)) {
                iVar.setNeedSkeleton(((Float) hashMap.get("param_value")).floatValue() == 1.0f);
            } else if ("need_triggers".equals(str2)) {
                iVar.setNeedTriggers(((Float) hashMap.get("param_value")).floatValue() == 1.0f);
            } else if ("need_expression".equals(str2)) {
                iVar.E(((Float) hashMap.get("param_value")).floatValue() == 1.0f);
            } else if ("need_dumoji".equals(str2)) {
                iVar.C(((Float) hashMap.get("param_value")).floatValue() == 1.0f);
            } else if ("prefer_max_face_count".equals(str2)) {
                iVar.F((int) ((Float) hashMap.get("param_value")).floatValue());
            }
        }
        return -1;
    }

    public static m a(FaceAlgoData faceAlgoData, long j, long j2, long j3, ByteBuffer byteBuffer, long j4, boolean z) {
        m mVar = new m(j4);
        mVar.a(faceAlgoData);
        mVar.i(j2);
        mVar.t(j);
        mVar.a(byteBuffer);
        mVar.r(j3);
        mVar.setFrontCamera(z);
        if (faceAlgoData != null && faceAlgoData.getFaceFrame() != null) {
            mVar.H(true);
            if (faceAlgoData.getFaceFrame().getProcessResult() == 200) {
                mVar.setTracked(true);
            } else {
                mVar.setTracked(false);
            }
        }
        return mVar;
    }

    public static boolean a(String str, String str2, String str3, String[] strArr, String str4, String str5, String str6, String str7) {
        if (TextUtils.isEmpty(str)) {
            com.baidu.ar.g.b.b("bdar-face", "error: imbinModelPath is null!");
            return true;
        } else if (TextUtils.isEmpty(str2)) {
            com.baidu.ar.g.b.b("bdar-face", "error: detectModelPath is null!");
            return true;
        } else if (TextUtils.isEmpty(str3)) {
            com.baidu.ar.g.b.b("bdar-face", "error: anglePath is null!");
            return true;
        } else if (strArr == null || strArr.length < 3) {
            com.baidu.ar.g.b.b("bdar-face", "error: trackModelPath is null, or length < 3!");
            return true;
        } else if (TextUtils.isEmpty(strArr[0])) {
            com.baidu.ar.g.b.b("bdar-face", "error: lite trackModelPath is null!");
            return true;
        } else if (TextUtils.isEmpty(strArr[1])) {
            com.baidu.ar.g.b.b("bdar-face", "error: medium trackModelPath is null!");
            return true;
        } else if (TextUtils.isEmpty(strArr[2])) {
            com.baidu.ar.g.b.b("bdar-face", "error: heavy trackModelPath is null!");
            return true;
        } else if (TextUtils.isEmpty(str4)) {
            com.baidu.ar.g.b.b("bdar-face", "error: eyesModelPath is null!");
            return true;
        } else if (TextUtils.isEmpty(str5)) {
            com.baidu.ar.g.b.b("bdar-face", "error: irisModelPath is null!");
            return true;
        } else if (TextUtils.isEmpty(str6)) {
            com.baidu.ar.g.b.b("bdar-face", "error: expressionModelPath is null!");
            return true;
        } else if (TextUtils.isEmpty(str7)) {
            com.baidu.ar.g.b.b("bdar-face", "error: mouthModelPath is null!");
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

    public static int c(String str, int i) {
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

    public static FaceResultData c(m mVar) {
        FaceResultData faceResultData = new FaceResultData();
        faceResultData.setTimestamp(mVar.getTimestamp());
        faceResultData.setTracked(mVar.isTracked());
        faceResultData.setFrontCamera(mVar.isFrontCamera());
        if (mVar.eD() != null && mVar.eD().getFaceFrame() != null) {
            FaceFrame faceFrame = mVar.eD().getFaceFrame();
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
                ArrayList arrayList = new ArrayList();
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
}
