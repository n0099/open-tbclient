package com.baidu.ar.face;

import android.graphics.PointF;
import android.text.TextUtils;
import com.baidu.ar.face.algo.FAUFaceBox;
import com.baidu.ar.face.algo.FAUPoint2D;
import com.baidu.ar.face.algo.FaceAlgoData;
import com.baidu.ar.face.algo.FaceFrame;
import com.baidu.ar.face.detector.i;
import com.baidu.ar.face.detector.m;
import com.baidu.nps.utils.Constant;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    public static int D(int i) {
        if (i != -90) {
            if (i != 0) {
                if (i != 90) {
                    return i != 180 ? -1 : 2;
                }
                return 1;
            }
            return 0;
        }
        return 3;
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
        if ("ability_operation".equals((String) hashMap.get("event_name")) && "ability_face_model".equals(str)) {
            com.baidu.ar.h.b.aR("bdar-face lua message:" + hashMap.toString());
            if ("face_model".equals(str2)) {
                String str3 = (String) hashMap.get(Constant.TAG.PARAM_VALUE);
                if ("v3".equals(str3) || "model_for_makeup".equals(str3)) {
                    iVar.G(2);
                    iVar.a(0.01f, 1.0f);
                    iVar.d(0.1f);
                    return 2;
                } else if ("v6".equals(str3)) {
                    iVar.G(0);
                    iVar.a(0.01f, 1.0f);
                    iVar.d(0.1f);
                    return 0;
                } else {
                    return -1;
                }
            } else if ("need_refine_eyes".equals(str2)) {
                iVar.z(((Float) hashMap.get(Constant.TAG.PARAM_VALUE)).floatValue() == 1.0f);
                return -1;
            } else if ("need_refine_mouth".equals(str2)) {
                iVar.B(((Float) hashMap.get(Constant.TAG.PARAM_VALUE)).floatValue() == 1.0f);
                return -1;
            } else if ("need_head_pose".equals(str2)) {
                iVar.setNeedHeadPose(((Float) hashMap.get(Constant.TAG.PARAM_VALUE)).floatValue() == 1.0f);
                return -1;
            } else if ("need_skeleton".equals(str2)) {
                iVar.setNeedSkeleton(((Float) hashMap.get(Constant.TAG.PARAM_VALUE)).floatValue() == 1.0f);
                return -1;
            } else if ("need_triggers".equals(str2)) {
                iVar.setNeedTriggers(((Float) hashMap.get(Constant.TAG.PARAM_VALUE)).floatValue() == 1.0f);
                return -1;
            } else if ("need_expression".equals(str2)) {
                iVar.C(((Float) hashMap.get(Constant.TAG.PARAM_VALUE)).floatValue() == 1.0f);
                return -1;
            } else if ("need_dumoji".equals(str2)) {
                iVar.A(((Float) hashMap.get(Constant.TAG.PARAM_VALUE)).floatValue() == 1.0f);
                return -1;
            } else if ("prefer_max_face_count".equals(str2)) {
                iVar.H((int) ((Float) hashMap.get(Constant.TAG.PARAM_VALUE)).floatValue());
                return -1;
            } else {
                return -1;
            }
        }
        return -1;
    }

    public static m a(FaceAlgoData faceAlgoData, long j, long j2, long j3, ByteBuffer byteBuffer, long j4, boolean z) {
        m mVar = new m(j4);
        mVar.a(faceAlgoData);
        mVar.g(j2);
        mVar.r(j);
        mVar.a(byteBuffer);
        mVar.p(j3);
        mVar.setFrontCamera(z);
        if (faceAlgoData != null && faceAlgoData.getFaceFrame() != null) {
            mVar.F(true);
            if (faceAlgoData.getFaceFrame().getProcessResult() == 200) {
                mVar.setTracked(true);
            } else {
                mVar.setTracked(false);
            }
        }
        return mVar;
    }

    public static boolean a(String str, String str2, String str3, String[] strArr, String str4, String str5, String str6, String str7) {
        String str8;
        if (TextUtils.isEmpty(str)) {
            str8 = "error: imbinModelPath is null!";
        } else if (TextUtils.isEmpty(str2)) {
            str8 = "error: detectModelPath is null!";
        } else if (TextUtils.isEmpty(str3)) {
            str8 = "error: anglePath is null!";
        } else if (strArr == null || strArr.length < 3) {
            str8 = "error: trackModelPath is null, or length < 3!";
        } else if (TextUtils.isEmpty(strArr[0])) {
            str8 = "error: lite trackModelPath is null!";
        } else if (TextUtils.isEmpty(strArr[1])) {
            str8 = "error: medium trackModelPath is null!";
        } else if (TextUtils.isEmpty(strArr[2])) {
            str8 = "error: heavy trackModelPath is null!";
        } else if (TextUtils.isEmpty(str4)) {
            str8 = "error: eyesModelPath is null!";
        } else if (TextUtils.isEmpty(str5)) {
            str8 = "error: irisModelPath is null!";
        } else if (TextUtils.isEmpty(str6)) {
            str8 = "error: expressionModelPath is null!";
        } else if (!TextUtils.isEmpty(str7)) {
            return false;
        } else {
            str8 = "error: mouthModelPath is null!";
        }
        com.baidu.ar.h.b.b("bdar-face", str8);
        return true;
    }

    public static int[] a(int[] iArr, int[] iArr2) {
        boolean z;
        if (iArr == null || iArr.length == 0) {
            return iArr2;
        }
        if (iArr2 == null || iArr2.length == 0) {
            return iArr;
        }
        if (iArr.length <= iArr2.length) {
            if (iArr.length < iArr2.length) {
                iArr2 = iArr;
                iArr = iArr2;
            } else {
                iArr = null;
                iArr2 = null;
            }
        }
        if (iArr == null || iArr2 == null) {
            return null;
        }
        int[] iArr3 = new int[iArr.length - iArr2.length];
        int i = 0;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            int i3 = 0;
            while (true) {
                if (i3 >= iArr2.length) {
                    z = false;
                    break;
                } else if (iArr[i2] == iArr2[i3]) {
                    z = true;
                    break;
                } else {
                    i3++;
                }
            }
            if (!z) {
                iArr3[i] = iArr[i2];
                i++;
            }
        }
        return iArr3;
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
        if (mVar.eC() != null && mVar.eC().getFaceFrame() != null) {
            FaceFrame faceFrame = mVar.eC().getFaceFrame();
            if (faceFrame.getFaceBoxes() != null && faceFrame.getFaceBoxes().size() > 0) {
                List<FAUFaceBox> faceBoxes = faceFrame.getFaceBoxes();
                float[] fArr = new float[faceBoxes.size() * 4];
                for (int i = 0; i < faceBoxes.size(); i++) {
                    FAUFaceBox fAUFaceBox = faceBoxes.get(i);
                    int i2 = i * 4;
                    fArr[i2] = fAUFaceBox.getX();
                    fArr[i2 + 1] = fAUFaceBox.getY();
                    fArr[i2 + 2] = fAUFaceBox.getWidth();
                    fArr[i2 + 3] = fAUFaceBox.getHeight();
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
