package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.util.Xml;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes.dex */
public class KeyFrames {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "KeyFrames";
    public static final int UNSET = -1;
    public static HashMap<String, Constructor<? extends Key>> sKeyMakers;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<Integer, ArrayList<Key>> mFramesMap;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-67713002, "Landroidx/constraintlayout/motion/widget/KeyFrames;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-67713002, "Landroidx/constraintlayout/motion/widget/KeyFrames;");
                return;
            }
        }
        HashMap<String, Constructor<? extends Key>> hashMap = new HashMap<>();
        sKeyMakers = hashMap;
        try {
            hashMap.put("KeyAttribute", KeyAttributes.class.getConstructor(new Class[0]));
            sKeyMakers.put("KeyPosition", KeyPosition.class.getConstructor(new Class[0]));
            sKeyMakers.put("KeyCycle", KeyCycle.class.getConstructor(new Class[0]));
            sKeyMakers.put("KeyTimeCycle", KeyTimeCycle.class.getConstructor(new Class[0]));
            sKeyMakers.put("KeyTrigger", KeyTrigger.class.getConstructor(new Class[0]));
        } catch (NoSuchMethodException unused) {
        }
    }

    public KeyFrames(Context context, XmlPullParser xmlPullParser) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, xmlPullParser};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mFramesMap = new HashMap<>();
        Key key = null;
        try {
            int eventType = xmlPullParser.getEventType();
            while (eventType != 1) {
                if (eventType != 2) {
                    if (eventType == 3 && "KeyFrameSet".equals(xmlPullParser.getName())) {
                        return;
                    }
                } else {
                    String name = xmlPullParser.getName();
                    if (sKeyMakers.containsKey(name)) {
                        try {
                            Key newInstance = sKeyMakers.get(name).newInstance(new Object[0]);
                            try {
                                newInstance.load(context, Xml.asAttributeSet(xmlPullParser));
                                addKey(newInstance);
                            } catch (Exception unused) {
                            }
                            key = newInstance;
                            continue;
                        } catch (Exception unused2) {
                            continue;
                        }
                    } else if (name.equalsIgnoreCase("CustomAttribute") && key != null && key.mCustomConstraints != null) {
                        ConstraintAttribute.parse(context, xmlPullParser, key.mCustomConstraints);
                        continue;
                    }
                }
                eventType = xmlPullParser.next();
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        } catch (XmlPullParserException e3) {
            e3.printStackTrace();
        }
    }

    private void addKey(Key key) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, key) == null) {
            if (!this.mFramesMap.containsKey(Integer.valueOf(key.mTargetId))) {
                this.mFramesMap.put(Integer.valueOf(key.mTargetId), new ArrayList<>());
            }
            this.mFramesMap.get(Integer.valueOf(key.mTargetId)).add(key);
        }
    }

    public static String name(int i2, Context context) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(65539, null, i2, context)) == null) ? context.getResources().getResourceEntryName(i2) : (String) invokeIL.objValue;
    }

    public void addFrames(MotionController motionController) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, motionController) == null) {
            ArrayList<Key> arrayList = this.mFramesMap.get(Integer.valueOf(motionController.mId));
            if (arrayList != null) {
                motionController.addKeys(arrayList);
            }
            ArrayList<Key> arrayList2 = this.mFramesMap.get(-1);
            if (arrayList2 != null) {
                Iterator<Key> it = arrayList2.iterator();
                while (it.hasNext()) {
                    Key next = it.next();
                    if (next.matches(((ConstraintLayout.LayoutParams) motionController.mView.getLayoutParams()).constraintTag)) {
                        motionController.addKey(next);
                    }
                }
            }
        }
    }

    public ArrayList<Key> getKeyFramesForView(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? this.mFramesMap.get(Integer.valueOf(i2)) : (ArrayList) invokeI.objValue;
    }

    public Set<Integer> getKeys() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mFramesMap.keySet() : (Set) invokeV.objValue;
    }
}
