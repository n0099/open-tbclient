package com.baidu.minivideo.arface.bean;

import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes5.dex */
public class Sticker extends BaseBeautyItem {
    private AbilityModel mAbilityModel;
    private int mArType;
    private File mFile;
    private String mId;
    private HashMap<String, HashMap> mLua;
    private int mMaxtVersion;
    private int mMinVersion;
    private List<AbilityModel> mSoFileList;
    private boolean mTouchAble;

    public void setArTyp(int i) {
        this.mArType = i;
    }

    public int getArType() {
        return this.mArType;
    }

    public void setLua(String str, HashMap hashMap) {
        if (this.mLua == null) {
            this.mLua = new HashMap<>();
        }
        this.mLua.put(str, hashMap);
    }

    public HashMap getLua(String str) {
        if (this.mLua != null) {
            return this.mLua.get(str);
        }
        return null;
    }

    public AbilityModel getAbilityModel() {
        return this.mAbilityModel;
    }

    public List<AbilityModel> getSoFile() {
        return this.mSoFileList;
    }

    public void setId(String str) {
        this.mId = str;
    }

    public String getId() {
        return this.mId;
    }

    public void setTouchAble(boolean z) {
        this.mTouchAble = z;
    }

    public boolean isTouchAble() {
        return this.mTouchAble;
    }

    public void setFile(File file) {
        this.mFile = file;
    }

    public File getFile() {
        return this.mFile;
    }

    public String getPath() {
        if (this.mFile == null) {
            return null;
        }
        return this.mFile.getAbsolutePath();
    }

    public boolean isSupport(int i) {
        return true;
    }

    public int getMiniVersion() {
        return this.mMinVersion;
    }

    public void setMiniVersion(int i) {
        this.mMinVersion = i;
    }

    public int getMaxVersion() {
        return this.mMaxtVersion;
    }

    public void setMaxVersion(int i) {
        this.mMaxtVersion = i;
    }

    public void setAbility(AbilityModel abilityModel) {
        this.mAbilityModel = abilityModel;
    }

    public void setSoFile(List<AbilityModel> list) {
        this.mSoFileList = list;
    }

    public List<AbilityModel> getSoFileList() {
        return this.mSoFileList;
    }

    /* loaded from: classes5.dex */
    public static class AbilityModel implements Serializable {
        private File mFile;

        public void setFile(File file) {
            this.mFile = file;
        }

        public File getFile() {
            return this.mFile;
        }

        public String getPath() {
            if (this.mFile == null) {
                return null;
            }
            return this.mFile.getAbsolutePath();
        }
    }
}
