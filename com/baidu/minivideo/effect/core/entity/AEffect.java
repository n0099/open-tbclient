package com.baidu.minivideo.effect.core.entity;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.minivideo.effect.core.b;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes11.dex */
public class AEffect implements Parcelable {
    public static final String AE_ANIM_ONCE = "once";
    public static final String AE_ANIM_ORDER = "order";
    public static final String AE_ANIM_RANDOM = "random";
    public static final String AE_ANIM_REPEAT = "repeat";
    public static final String AE_ANIM_REVERSE = "reverse";
    public static final String AE_IMAGE = "image";
    public static final String AE_RES_LOCAL = "1";
    public static final String AE_RES_REMOTE = "2";
    public static final String AE_SIMPLE = "simple";
    public static final Parcelable.Creator<AEffect> CREATOR = new Parcelable.Creator<AEffect>() { // from class: com.baidu.minivideo.effect.core.entity.AEffect.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: cU */
        public AEffect[] newArray(int i) {
            return new AEffect[i];
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: m */
        public AEffect createFromParcel(Parcel parcel) {
            return new AEffect(parcel);
        }
    };
    public float animDuration;
    public List<AEffectAnimatorGroup> animGroup;
    public String animOrderMode;
    public String animRepeatMode;
    public boolean animated;
    public List<AEffectParams> fParams;
    public String fragmentShader;
    public String name;
    public String resourceType;
    public List<AEffectTextureParams> textureParams;
    public List<AEffectAnimatorGroup> totalAnimGroup;
    public List<AEffectParams> vParams;
    public String vertexShader;

    public AEffect() {
        this.resourceType = "1";
        this.animRepeatMode = AE_ANIM_REPEAT;
        this.animOrderMode = AE_ANIM_ORDER;
    }

    protected AEffect(Parcel parcel) {
        this.resourceType = "1";
        this.animRepeatMode = AE_ANIM_REPEAT;
        this.animOrderMode = AE_ANIM_ORDER;
        this.name = parcel.readString();
        this.resourceType = parcel.readString();
        this.textureParams = parcel.createTypedArrayList(AEffectTextureParams.CREATOR);
        this.vertexShader = parcel.readString();
        this.vParams = parcel.createTypedArrayList(AEffectParams.CREATOR);
        this.fragmentShader = parcel.readString();
        this.fParams = parcel.createTypedArrayList(AEffectParams.CREATOR);
        this.animated = parcel.readByte() != 0;
        this.animDuration = parcel.readFloat();
        this.animRepeatMode = parcel.readString();
        this.animOrderMode = parcel.readString();
        this.animGroup = parcel.createTypedArrayList(AEffectAnimatorGroup.CREATOR);
        this.totalAnimGroup = parcel.createTypedArrayList(AEffectAnimatorGroup.CREATOR);
    }

    private int W(Context context, String str) {
        try {
            return context.getResources().getIdentifier(str, "raw", context.getApplicationInfo().packageName);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    private int d(String str, Context context) {
        try {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            int identifier = context.getResources().getIdentifier(str, "drawable", applicationInfo.packageName);
            return identifier == 0 ? context.getResources().getIdentifier(str, "mipmap", applicationInfo.packageName) : identifier;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public Bitmap[] S(Context context, String str) {
        int i = 0;
        ArrayList arrayList = new ArrayList();
        for (AEffectTextureParams aEffectTextureParams : this.textureParams) {
            if ("image".equals(aEffectTextureParams.type)) {
                arrayList.add(aEffectTextureParams);
            }
        }
        Bitmap[] bitmapArr = new Bitmap[arrayList.size()];
        if ("1".equals(this.resourceType)) {
            while (i < bitmapArr.length) {
                bitmapArr[i] = BitmapFactory.decodeResource(context.getResources(), d(((AEffectTextureParams) arrayList.get(i)).value, context));
                i++;
            }
        } else {
            while (i < bitmapArr.length) {
                bitmapArr[i] = BitmapFactory.decodeFile(str + File.separator + ((AEffectTextureParams) arrayList.get(i)).value);
                i++;
            }
        }
        return bitmapArr;
    }

    public List<Object> T(Context context, String str) {
        int i = 0;
        ArrayList arrayList = new ArrayList();
        for (AEffectTextureParams aEffectTextureParams : this.textureParams) {
            if ("video".equals(aEffectTextureParams.type)) {
                arrayList.add(aEffectTextureParams);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        if ("1".equals(this.resourceType)) {
            while (i < arrayList.size()) {
                arrayList2.add(context.getResources().openRawResourceFd(W(context, ((AEffectTextureParams) arrayList.get(i)).value)));
                i++;
            }
        } else {
            while (i < arrayList.size()) {
                arrayList2.add(str + File.separator + ((AEffectTextureParams) arrayList.get(i)).value);
                i++;
            }
        }
        return arrayList2;
    }

    public String U(Context context, String str) {
        return "1".equals(this.resourceType) ? b.a(context, W(context, this.fragmentShader)) : b.a(str + File.separator + this.fragmentShader);
    }

    public String V(Context context, String str) {
        return "1".equals(this.resourceType) ? b.a(context, W(context, this.vertexShader)) : b.a(str + File.separator + this.vertexShader);
    }

    public void cT(int i) {
        ArrayList arrayList;
        AEffectAnimatorGroup aEffectAnimatorGroup;
        AEffectAnimatorGroup aEffectAnimatorGroup2;
        AEffectAnimatorGroup aEffectAnimatorGroup3;
        AEffectAnimatorGroup aEffectAnimatorGroup4 = null;
        if (this.animGroup == null) {
            return;
        }
        if (this.totalAnimGroup == null) {
            this.totalAnimGroup = new ArrayList();
        }
        this.totalAnimGroup.clear();
        if (this.animGroup.size() == 1) {
            this.totalAnimGroup.addAll(this.animGroup);
            return;
        }
        boolean z = !TextUtils.equals(this.animOrderMode, AE_ANIM_ORDER);
        if (z) {
            ArrayList arrayList2 = new ArrayList(this.animGroup);
            Iterator it = arrayList2.iterator();
            ArrayList arrayList3 = new ArrayList();
            AEffectAnimatorGroup aEffectAnimatorGroup5 = null;
            aEffectAnimatorGroup = null;
            while (it.hasNext()) {
                AEffectAnimatorGroup aEffectAnimatorGroup6 = (AEffectAnimatorGroup) it.next();
                if (aEffectAnimatorGroup6.priority == 1) {
                    it.remove();
                    aEffectAnimatorGroup = aEffectAnimatorGroup6;
                } else if (aEffectAnimatorGroup6.priority == 100) {
                    it.remove();
                    aEffectAnimatorGroup5 = aEffectAnimatorGroup6;
                } else if (aEffectAnimatorGroup6.priority / 10 > 0) {
                    arrayList3.add(aEffectAnimatorGroup6);
                    it.remove();
                }
            }
            int size = i - (this.animGroup.size() - (arrayList2.size() + arrayList3.size()));
            if (size < arrayList3.size()) {
                arrayList3.clear();
            }
            int size2 = arrayList3.size();
            for (int i2 = 0; i2 < size - size2; i2++) {
                arrayList3.add((AEffectAnimatorGroup) arrayList2.get(i2 % arrayList2.size()));
            }
            Collections.shuffle(arrayList3);
            arrayList2.clear();
            arrayList2.addAll(arrayList3);
            aEffectAnimatorGroup4 = aEffectAnimatorGroup5;
            arrayList = arrayList2;
        } else {
            arrayList = null;
            aEffectAnimatorGroup = null;
        }
        int i3 = 0;
        AEffectAnimatorGroup aEffectAnimatorGroup7 = aEffectAnimatorGroup;
        AEffectAnimatorGroup aEffectAnimatorGroup8 = aEffectAnimatorGroup4;
        while (true) {
            if (i3 >= i) {
                break;
            }
            if (!z) {
                aEffectAnimatorGroup2 = this.animGroup.get(i3 % this.animGroup.size());
                if (aEffectAnimatorGroup7 == null && aEffectAnimatorGroup2.priority == 1) {
                    AEffectAnimatorGroup aEffectAnimatorGroup9 = aEffectAnimatorGroup8;
                    aEffectAnimatorGroup3 = aEffectAnimatorGroup2;
                    aEffectAnimatorGroup2 = aEffectAnimatorGroup9;
                } else if (aEffectAnimatorGroup8 == null && aEffectAnimatorGroup2.priority == 100) {
                    aEffectAnimatorGroup3 = aEffectAnimatorGroup7;
                } else {
                    this.totalAnimGroup.add(aEffectAnimatorGroup2);
                    aEffectAnimatorGroup2 = aEffectAnimatorGroup8;
                    aEffectAnimatorGroup3 = aEffectAnimatorGroup7;
                }
            } else if (i3 == 0 && aEffectAnimatorGroup7 != null) {
                aEffectAnimatorGroup2 = aEffectAnimatorGroup8;
                aEffectAnimatorGroup3 = aEffectAnimatorGroup7;
            } else if (i3 == i - 1 && aEffectAnimatorGroup8 != null) {
                aEffectAnimatorGroup2 = aEffectAnimatorGroup8;
                aEffectAnimatorGroup3 = aEffectAnimatorGroup7;
            } else if (arrayList.size() > 0) {
                this.totalAnimGroup.addAll(arrayList);
                break;
            } else {
                this.totalAnimGroup.add(this.animGroup.get(i3 % this.animGroup.size()));
                aEffectAnimatorGroup2 = aEffectAnimatorGroup8;
                aEffectAnimatorGroup3 = aEffectAnimatorGroup7;
            }
            i3++;
            aEffectAnimatorGroup7 = aEffectAnimatorGroup3;
            aEffectAnimatorGroup8 = aEffectAnimatorGroup2;
        }
        if (aEffectAnimatorGroup7 != null) {
            this.totalAnimGroup.add(0, aEffectAnimatorGroup7);
        }
        if (aEffectAnimatorGroup8 != null) {
            this.totalAnimGroup.add(this.totalAnimGroup.size(), aEffectAnimatorGroup8);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeString(this.resourceType);
        parcel.writeTypedList(this.textureParams);
        parcel.writeString(this.vertexShader);
        parcel.writeTypedList(this.vParams);
        parcel.writeString(this.fragmentShader);
        parcel.writeTypedList(this.fParams);
        parcel.writeByte(this.animated ? (byte) 1 : (byte) 0);
        parcel.writeFloat(this.animDuration);
        parcel.writeString(this.animRepeatMode);
        parcel.writeString(this.animOrderMode);
        parcel.writeTypedList(this.animGroup);
        parcel.writeTypedList(this.totalAnimGroup);
    }
}
