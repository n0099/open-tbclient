package com.baidu.searchbox.ng.ai.apps.textarea.parser;

import android.text.TextWatcher;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class TextAreaBaseParser {
    protected static final boolean DEBUG = false;
    private static final String TAG = "TextAreaBaseParser";
    private static TextAreaBaseParser sInstance;
    private HashMap<String, TextAreaSecondaryParser> mHashMap = new HashMap<>();
    private TextWatcher mTextWatcher;

    private TextAreaBaseParser() {
    }

    public static TextAreaBaseParser getInstance() {
        if (sInstance == null) {
            synchronized (TextAreaBaseParser.class) {
                if (sInstance == null) {
                    sInstance = new TextAreaBaseParser();
                }
            }
        }
        return sInstance;
    }

    private TextAreaSecondaryParser createTextAreaSecondaryParser(String str) {
        AiAppsLog.d(TAG, "createTextAreaSecondaryParser slaveId:" + str);
        TextAreaSecondaryParser textAreaSecondaryParser = new TextAreaSecondaryParser();
        this.mHashMap.put(str, textAreaSecondaryParser);
        return textAreaSecondaryParser;
    }

    public TextAreaSecondaryParser getOrCreateSecondaryParser(String str) {
        AiAppsLog.d(TAG, "getOrCreateSecondaryParser slaveId:" + str);
        TextAreaSecondaryParser textAreaSecondaryParser = getTextAreaSecondaryParser(str);
        if (textAreaSecondaryParser == null) {
            return createTextAreaSecondaryParser(str);
        }
        return textAreaSecondaryParser;
    }

    public TextAreaSecondaryParser getTextAreaSecondaryParser(String str) {
        AiAppsLog.d(TAG, "getTextAreaSecondaryParser slaveId:" + str);
        return this.mHashMap.get(str);
    }

    public void destroyTextAreaSecondaryParser(String str) {
        AiAppsLog.d(TAG, "destroyTextAreaSecondaryParser slaveId:" + str);
        this.mHashMap.remove(str);
    }

    public TextWatcher getTextWatcher() {
        return this.mTextWatcher;
    }

    public void setTextWatcher(TextWatcher textWatcher) {
        this.mTextWatcher = textWatcher;
    }
}
