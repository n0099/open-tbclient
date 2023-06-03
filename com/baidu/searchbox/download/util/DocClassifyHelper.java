package com.baidu.searchbox.download.util;

import androidx.annotation.NonNull;
import com.baidu.android.util.io.DocumentOpenUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public final class DocClassifyHelper {
    public static HashMap<String, DocCategroy> sExtTypeMap = new HashMap<>();
    public static HashMap<String, DocCategroy> sMimeTypeMap = new HashMap<>();

    /* loaded from: classes3.dex */
    public enum DocCategroy {
        ALL,
        RECENT,
        TEXT,
        WORD,
        PPT,
        PDF,
        EXCEL,
        OTHERS,
        OFFICE
    }

    static {
        add(DocumentOpenUtil.PDF_TYPE, "pdf", DocCategroy.PDF);
        add(DocumentOpenUtil.WORD_TYPE, "doc", DocCategroy.WORD);
        add(DocumentOpenUtil.WORD_TYPE, "dot", DocCategroy.WORD);
        add(DocumentOpenUtil.DOCUMENT_TYPE, DocumentOpenUtil.DOCX, DocCategroy.WORD);
        add("application/vnd.openxmlformats-officedocument.wordprocessingml.template", "dotx", DocCategroy.WORD);
        add(DocumentOpenUtil.EXCEL_TYPE, "xls", DocCategroy.EXCEL);
        add(DocumentOpenUtil.EXCEL_TYPE, "xlt", DocCategroy.EXCEL);
        add(DocumentOpenUtil.SHEET_TYPE, DocumentOpenUtil.XLSX, DocCategroy.EXCEL);
        add("application/vnd.openxmlformats-officedocument.spreadsheetml.template", "xltx", DocCategroy.EXCEL);
        add(DocumentOpenUtil.PPT_TYPE, "ppt", DocCategroy.PPT);
        add(DocumentOpenUtil.PPT_TYPE, "pot", DocCategroy.PPT);
        add(DocumentOpenUtil.PPT_TYPE, "pps", DocCategroy.PPT);
        add(DocumentOpenUtil.PRESENT_TYPE, DocumentOpenUtil.PPTX, DocCategroy.PPT);
        add("application/vnd.openxmlformats-officedocument.presentationml.template", "potx", DocCategroy.PPT);
        add("application/vnd.openxmlformats-officedocument.presentationml.slideshow", "ppsx", DocCategroy.PPT);
        add("text/plain", "txt", DocCategroy.TEXT);
        add("text/plain", "text", DocCategroy.TEXT);
        add("application/force-download", "text", DocCategroy.TEXT);
    }

    public static void add(String str, String str2, DocCategroy docCategroy) {
        sExtTypeMap.put(str2, docCategroy);
        sMimeTypeMap.put(str, docCategroy);
    }

    public static DocCategroy getDocDetailType(String str, String str2) {
        DocCategroy docCategroy = sMimeTypeMap.get(str2);
        if (docCategroy == null) {
            DocCategroy docCategroy2 = sExtTypeMap.get(str);
            if (docCategroy2 == null) {
                return DocCategroy.OTHERS;
            }
            return docCategroy2;
        }
        return docCategroy;
    }

    @NonNull
    public static ArrayList<String> getMimeTypesByType(DocCategroy docCategroy) {
        DocCategroy value;
        ArrayList<String> arrayList = new ArrayList<>();
        HashMap<String, DocCategroy> hashMap = sMimeTypeMap;
        if (hashMap != null) {
            for (Map.Entry<String, DocCategroy> entry : hashMap.entrySet()) {
                if (docCategroy != DocCategroy.ALL && docCategroy != DocCategroy.RECENT && entry.getValue() != docCategroy) {
                    if (docCategroy == DocCategroy.OFFICE && ((value = entry.getValue()) == DocCategroy.WORD || value == DocCategroy.PPT || value == DocCategroy.EXCEL)) {
                        arrayList.add(entry.getKey());
                    }
                } else {
                    arrayList.add(entry.getKey());
                }
            }
        }
        return arrayList;
    }
}
